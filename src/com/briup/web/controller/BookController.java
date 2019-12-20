package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.briup.bean.Book;
import com.briup.bean.Customer;
import com.briup.bean.OrderLine;
import com.briup.bean.ShoppingCar;
import com.briup.exception.BookException;
import com.briup.service.IBookService;

@Controller
public class BookController {
	@Autowired
	private IBookService bookservice;
	

	@RequestMapping("/list")
	public String toList() {
		return "list";
	}
	@RequestMapping("/viewBook")
	public String toView() {
		return "viewBook";
	}
	@RequestMapping(value= "/shopCar")
	public String toShopCar() {
		return "shopCar";
	}
	
	// 查看大分类中的书籍
	@RequestMapping("/listBook")
	public String listBook(HttpServletRequest request, HttpSession session) {
		String categoryId = request.getParameter("categoryId");
		if (categoryId != null) {
			int id = Integer.parseInt(categoryId);
			try {
				String fatherName = bookservice.getFatherName(id);
				String kidName = bookservice.getKidName(id);
				List<Book> books = bookservice.getBooks(id);
				session.setAttribute("books", books);
				session.setAttribute("fatherName", fatherName);
				session.setAttribute("kidName", kidName);
				return "redirect:/list";
			} catch (BookException e) {
				e.printStackTrace();
			}
		} else {
			return "forward:/list";
		}
		return "warn";
	}
	// 查看具体某本书籍的详细信息
	@RequestMapping("/bookList")
	public String bookList(HttpServletRequest request, HttpSession session) {
		String bookId = request.getParameter("bookId");
		if (bookId != null) {
			int id = Integer.parseInt(bookId);
			try {
				Book book = bookservice.getBook(id);
				session.setAttribute("book", book);
				return "redirect:/viewBook";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "warn";
	}
	// 添加到购物车
	@RequestMapping("/addShopping")
	public String addShopping(HttpServletRequest request
			,@SessionAttribute("shopCar") ShoppingCar car,@SessionAttribute("customer") Customer cus) {
		String bookId = request.getParameter("bookId");
		String num2 = request.getParameter("num");
		System.out.println("======" + bookId + "号书，"+cus+"购买了" + num2 + "本======");
		System.out.println("当前购物车对象:"+car);
		if (car == null) {
			return "redirect:/loginOut";
		} else {
			if (bookId != null) {
				int id = Integer.parseInt(bookId);
				int num = Integer.parseInt(num2);
				try {
					Book book = bookservice.getBook(id);
					if (book.getKuc() < num) {
						throw new BookException("库存不足,请重新选择数量");
					}else {
						OrderLine line = new OrderLine(num, book.getPrice() * num, book, null);
						car.add(line);
						return "redirect:/shopCar";
					}
				} catch (Exception e) {
					System.err.println(e.getMessage());
					request.getSession().setAttribute("book_msg", e.getMessage());
					return "/viewBook";
				}
			}
		}
		return "warn";
	}
	// 修改购物车中书的数目
		@RequestMapping("/alterBook")
		public String alterBook(HttpServletRequest request,@SessionAttribute("shopCar")ShoppingCar car) {
			String num2 = request.getParameter("num");
			String bookId = request.getParameter("bookId");
			System.out.println("bookId: " + bookId + " num: " + num2);
			System.out.println("======= 当前购物车对象："+car+"======");
			if (bookId != null) {
				int id = Integer.parseInt(bookId);
				int num = Integer.parseInt(num2);
				try {
					Book book = bookservice.getBook(id);
					if (book.getKuc() < num) {
						throw new BookException("库存不足,请重新选择数量");
					}else {
						int result = book.getKuc() - num;
						car.update(id, num);
						bookservice.updateBookKuc(result, book);
						return "redirect:/shopCar";
					}
				} catch (Exception e) {
					System.err.println(e.getMessage());
					request.getSession().setAttribute("book_msg", e.getMessage());
					return "/shopCar";
				}
			}
			return "warn";
		}
}
