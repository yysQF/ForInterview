package com.briup.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Address;
import com.briup.bean.Customer;
import com.briup.exception.CustomerException;
import com.briup.service.ICustomerService;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService customerService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/confirm")
	public String confirm() {
		return "confirm";
	}
	@RequestMapping(value= {"/loginOut","/toLogin"})
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "login";
	}
	// 用户登录
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpSession session) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		// 调用service去进行判断
		Customer customer = null;
		try {
			customer = customerService.login(name, password);
			// 存放登陆数据
			session.setAttribute("customer", customer);
			return "index";
		} catch (CustomerException e) {
			System.err.println("发生异常：" + e.getMessage());
			request.setAttribute("msg", e.getMessage());
			return "login";
		}
	}
	// 用户注册
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	@RequestMapping("/register_Form")
	public String register(HttpServletRequest request,HttpSession session) {
		/*
		 * 获取页面数据 
		 */
		String name = 
				request.getParameter("name");
		String password = 
				request.getParameter("password");
		String zipCode = 
				request.getParameter("zipCode");
		String telephone = 
				request.getParameter("telephone");
		String email = 
				request.getParameter("email");
		String addr = 
				request.getParameter("address");
		try {
			
			// 调用service
			
			/*
			 * 将接收数据封装对象
			 */
			Customer customer = new Customer(name,password,zipCode,telephone,email,new Address(addr));
			// 保存数据
			customerService.register(customer);
//			session.setAttribute("msg", "注册成功请登陆");
			return "login";
		} catch (Exception e) {
			// 发生异常需要对异常进行处理
			// 并且把异常信息发送给页面让用户看到
			request.setAttribute("msg", "注册失败，请重新注册:" + e.getMessage());
			return "register";
		}
	}
}
