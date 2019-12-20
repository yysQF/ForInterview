package com.briup.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author thomas
 * order_from表  订单表
 *
 */
public class Order {
	private Integer orderFormId;
	private Double cost;//总价钱
	private Date orderDate;
	private Customer customer;
	private List<OrderLine> orderLines;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public Order() {}
	public Order(Double cost, Date orderDate, Customer customer) {
		this.cost = cost;
		this.orderDate = orderDate;
		this.customer = customer;
	}
	public Order(Double cost, Date orderDate) {
		this.cost = cost;
		this.orderDate = orderDate;
	}
	
	public Double getCost() {
		return cost;
	}
	public Order(Integer orderFormId, Double cost, Date orderDate, Customer customer) {
		super();
		this.orderFormId = orderFormId;
		this.cost = cost;
		this.orderDate = orderDate;
		this.customer = customer;
	}
	public Integer getOrderFormId() {
		return orderFormId;
	}
	public void setOrderFormId(Integer orderFormId) {
		this.orderFormId = orderFormId;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getOrderDate() {
		return sdf.format(orderDate);
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=").append(orderFormId).append(", cost=").append(cost).append(", orderDate=").append(orderDate)
				.append(", customer=").append(customer).append(", orderLines=").append(orderLines).append("]");
		return builder.toString();
	}
	
}