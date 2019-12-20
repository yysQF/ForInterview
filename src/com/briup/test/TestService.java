package com.briup.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.Address;
import com.briup.bean.Book;
import com.briup.bean.Customer;
import com.briup.bean.OrderLine;
import com.briup.bean.ShoppingCar;
import com.briup.dao.BookDao;
import com.briup.dao.CustomerDao;
import com.briup.service.ICategoryService;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CategoryServiceImpl;

public class TestService {

	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	
	private ICustomerService service1;
	private CustomerDao cusDao;
	
	ShoppingCar car;

	@Test
	public void testSer() throws Exception {
		ICustomerService service = (ICustomerService) context.getBean(ICustomerService.class);
		CustomerDao cusDao = context.getBean(CustomerDao.class);
//		System.out.println(service1 != null);
//		Customer customer = service.login("Amy", "123");
		Customer customer = cusDao.findCustomerByName("Amy");
		System.out.println(customer);
	}

	@Test
	public void testCategory() {
		/*
		 * new 这个对象，再调用get方法就会空指针，待解决。
		 */
		ICategoryService service = new CategoryServiceImpl();
//		ICategoryService service = context.getBean(ICategoryService.class);
		System.out.println(service);
		// List<Category> list = service.getCategories();
		// System.out.println(list);
	}

	@Test
	public void testShopCar() {
		Book book = new Book(1, "213", 20.2, "", "", new Date(), "", 2);
		System.out.println(book);
		OrderLine line = new OrderLine();
		line.setBook(book);
		System.out.println(line);
		car.add(line);
		System.out.println(car);
	}
	
	@Test
	public void addAddr() throws Exception {
		CustomerDao cusDao = context.getBean(CustomerDao.class);
		Address addr = new Address("中国-上海-苏州河");
		Customer cus = new Customer(null,"111","111","123","123","123",addr);
		cusDao.addCustomer(cus);
		System.out.println(cusDao);
		Address addr2 = new Address("中国","太原","大望路",cus);
		//cusDao.addAddr(addr2);
		System.out.println("...");
	}
	
	@Test
	// 添加默认地址
	public void testAddAddress() throws Exception {
		CustomerDao cusDao = context.getBean(CustomerDao.class);
		Address addr = new Address("中国-上海-苏州河");
		Customer cus = new Customer(null,"111","111","123","123","123",addr);
		cusDao.addCustomer(cus);
		//Address addr = new Address("12", "12", "12",customer);
		cusDao.addAddr(cus);
	}
	@Test
	public void testBook() {
		BookDao bookDao = context.getBean(BookDao.class);
		bookDao.updateBook(20,1);
		System.out.println("更新完成");
	}
}
