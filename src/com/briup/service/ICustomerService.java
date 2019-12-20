package com.briup.service;

import com.briup.bean.Address;
import com.briup.bean.Customer;
import com.briup.exception.CustomerException;

public interface ICustomerService {
	// 注册
	public void register(Customer cus) throws CustomerException;
	// 登录
	public Customer login(String name,String pwd) throws CustomerException;
	
	// 注册信息中的地址添加进地址表(注册的同时添加默认地址)
	
	// 添加收货地址地址
	public void insertAddr(Address addr) throws CustomerException;
}
