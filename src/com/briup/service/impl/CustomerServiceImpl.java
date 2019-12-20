package com.briup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.briup.bean.Address;
import com.briup.bean.Customer;
import com.briup.dao.CustomerDao;
import com.briup.exception.CustomerException;
import com.briup.service.ICustomerService;
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerDao cusDao;

	// 由Spring 通过配置文件注入
	public void setCusDao(CustomerDao cusDao) {
		this.cusDao = cusDao;
	}

	// 验证注册，前提：通过前端验证，信息输入无误的情况下。
	@Override
	public void register(Customer cus) throws CustomerException {
		String name = cus.getName();
		try {
			Customer c = cusDao.findCustomerByName(name);
			if (c == null && cus != null) {
				cusDao.addCustomer(cus);
				// 默认地址与顾客一对一
				cusDao.addAddr(cus);
				System.out.println("注册成功,默认地址也已经添加");
			} else {
				throw new Exception("该用户已存在 or 用户为空");
			}
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());
		}
	}

	@Override
	public Customer login(String name, String pwd) throws CustomerException {
		Customer c = null;
		try {
			c = cusDao.findCustomerByName(name);
			if (c == null) {
				throw new Exception("用户不存在，请先去注册");
			} else {
				if (pwd.equals(c.getPassword())) {
					System.out.println("用户在库");
				} else {
					throw new Exception("密码错误");
				}
			}
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());
		}
		return c;
	}

	@Override
	public void insertAddr(Address addr) throws CustomerException {
		try {
			System.out.println("添加收货地址方法调用");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
