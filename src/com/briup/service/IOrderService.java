package com.briup.service;

import java.util.List;

import com.briup.bean.Order;
import com.briup.bean.OrderLine;

public interface IOrderService {
	// 提交订单
	public void getSaveOrder(Order o);
	
	// 查询订单通过用户Id
	public List<Order> getOrders(int customerId);
	// 查询订单通过订单Id
	public Order getOrderById(int id);
	// 查询明细通过订单号
	public List<OrderLine> getLinesWithBook(int orderFormId);
	
	// 查询某一订单项的总价
	public Double getAllCost(int orderFormId);
	
	// 删除订单
	public void deleteOrder(int orderFormId);
	public void deleteOrderLine(int orderFormId);
	
}
