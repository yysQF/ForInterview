package com.briup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.briup.bean.Address;
import com.briup.bean.Customer;

//映射接口

public interface CustomerDao {
	//用户注册
	public void addCustomer(Customer cus) throws Exception;
	
	//用户登录
	public Customer findCustomerByName(
			String name)
			throws Exception;
	// 用户查询
	public List<Customer> AllCus();
	
	// 用户删除
	public int deleteCusById();
	
	// 地址添加
	public void addAddr(Customer cus);
}
