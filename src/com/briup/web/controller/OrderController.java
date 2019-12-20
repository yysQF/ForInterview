package com.briup.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.briup.bean.Customer;
import com.briup.bean.Order;
import com.briup.bean.OrderLine;
import com.briup.bean.ShoppingCar;
import com.briup.service.IOrderService;

@Controller
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	// 删除订单
	@RequestMapping("/deleteOrder")
	public String deleteOrder(HttpServletRequest request) {
		String orderFormId = request.getParameter("orderFormId");
		if (orderFormId != null) {
			int id = Integer.parseInt(orderFormId);
			orderService.deleteOrderLine(id);
			orderService.deleteOrder(id);
			System.out.println(id + "号订单删除成功");
			return "redirect:/saveOrder";
		}else {
			return "warn";
		}
	}
	// 保存订单到数据库
	@RequestMapping("/saveList")
	public String saveList(HttpServletRequest request
				,@SessionAttribute("shopCar")ShoppingCar car,@SessionAttribute("customer")Customer cus) {
		System.out.println("======= 当前购物车对象："+car+"======");
		System.out.println("======= 当前用户："+cus+"======");
		List<OrderLine> list = new ArrayList<>();
		if(cus == null) {
			return "redirect:/login";
		}else {
			Order o = new Order(null,car.getCost(),new Date(),cus);
			for(OrderLine lines:car.getLines().values()) {
				lines.setOrder(o);
				list.add(lines);
			}
			o.setOrderLines(list);
			orderService.getSaveOrder(o);
			
			car.clear();
			return "redirect:/saveOrder";
		}
	}
	// 显示订单列表
	@RequestMapping("/saveOrder")
	public String saveOrder(HttpServletRequest request,HttpSession session,@SessionAttribute("customer")Customer cus) {
		if (cus.getCustomerId() != null) {
			Integer customerId = cus.getCustomerId();
			List<Order> list = orderService.getOrders(customerId);
			session.setAttribute("OrderList", list);
			return "orderlist";
		}else {
			return "redirect:/login";
		}
	}
	// 查看订单明细
	@RequestMapping("/saveLine")
	public String saveLine(HttpServletRequest request,HttpSession session) {
		String orderFormId = request.getParameter("orderFormId");
		if (orderFormId!=null) {
			int id = Integer.parseInt(orderFormId);
			List<OrderLine> bookLines = orderService.getLinesWithBook(id);
			Double allCost = orderService.getAllCost(id);
			session.setAttribute("bookLines", bookLines);
			session.setAttribute("allCost", allCost);
			return "orderdetail";
		}else {
			return "warn";
		}
	}
}
