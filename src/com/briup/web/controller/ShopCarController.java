package com.briup.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.briup.bean.Book;
import com.briup.bean.ShoppingCar;
import com.briup.exception.BookException;

@Controller
public class ShopCarController {

	// 删除购物车
	@RequestMapping("deleteShopCar")
	public String deleteShopCar(HttpServletRequest request,@SessionAttribute("shopCar") ShoppingCar car) {
		String bookId = request.getParameter("bookId");
		System.out.println(bookId);
		System.out.println("======= 当前购物车对象："+car+"======");
		if (bookId != null) {
			int id = Integer.parseInt(bookId);
			try {
				car.delete(id);
				return "redirect:/shopCar";
			} catch (Exception e) {
			}
		}
		return "warn";
	}
	
}
