package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.briup.bean.Order;
import com.briup.bean.OrderLine;
import com.briup.dao.OrderDao;
import com.briup.service.IOrderService;
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

public class OrderServiceImpl implements IOrderService{
	@Autowired
	private OrderDao dao;
	
	/**
	 * 		待测试 是否需要回滚？？？
	 */
	@Override
	public void getSaveOrder(Order o) {
		dao.saveOrder(o);
		List<OrderLine> lines = o.getOrderLines();
		for (OrderLine orderLine : lines) {
			dao.saveOrderLine(orderLine);
		}
	}
	@Override
	public List<Order> getOrders(int customerId) {
		
 		return dao.selectOrders(customerId);
	}
	@Override
	public List<OrderLine> getLinesWithBook(int orderFormId) {
		
		return dao.selectLinesWithOther(orderFormId);
	}
	@Override
	public Double getAllCost(int orderFormId) {
		return dao.selectAllCostById(orderFormId);
	}
	@Override
	public void deleteOrder(int orderFormId) {
		dao.deleteOrderById(orderFormId);
	}
	@Override
	public void deleteOrderLine(int orderFormId) {
		dao.deleteOrderLineById(orderFormId);
	}
	@Override
	public Order getOrderById(int id) {

		return dao.selectOrderById(id);
	}
}
