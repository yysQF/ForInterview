package com.briup.dao;

import java.util.List;

import com.briup.bean.Order;
import com.briup.bean.OrderLine;

public interface OrderDao {
	// 添加订单
	public int saveOrder(Order o);

	// 删除订单  --级联订单项
	public void deleteOrderById(int id);
	public void deleteOrderLineById(int id);
	//public void deleteOrderLineByBookId(int id);

	// 查询订单  -- 级联订单项
	public List<Order> selectOrders(int customerId);
	public List<Order> selectOrderWithLine();
	public Order selectOrderById(int orderFormId);

	// 保存明细
	public int saveOrderLine(OrderLine o);

	// 查看明细
	public List<OrderLine> selectLines(int orderFormId);
	public Double selectAllCostById(int orderFormId);
	
	// 查看明细级联图书
	public List<OrderLine> selectLinesWithOther(int orderFormId);
}
