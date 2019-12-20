package com.briup.bean;

import org.springframework.stereotype.Component;


/**
 * 客户类 --注册 ，登录
 *
 */
@Component
public class Customer {
	private Integer customerId;// 主键id
	private String name;// 用户名
	private String password;// 密码
	private String zipCode;// 邮编
	private String telephone;// 电话号码
	private String email;// 邮箱
	private Address address;

	public Customer() {
	}

	public Customer(Integer customerId,String name, String password, String zipCode, String telephone, String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.password = password;
		this.zipCode = zipCode;
		this.telephone = telephone;
		this.email = email;
	}
	public Customer(String name, String password, String zipCode, String telephone, String email) {
		this.name = name;
		this.password = password;
		this.zipCode = zipCode;
		this.telephone = telephone;
		this.email = email;
	}
	public Customer(String name, String password, String zipCode, String telephone, String email,Address address) {
		this.name = name;
		this.password = password;
		this.zipCode = zipCode;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
	}
	
	public Customer(Integer customerId, String name, String password, String zipCode, String telephone, String email,
			Address address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.password = password;
		this.zipCode = zipCode;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [customerId=").append(customerId).append(", name=").append(name).append(", password=")
				.append(password).append(", zipCode=").append(zipCode).append(", telephone=").append(telephone)
				.append(", email=").append(email).append(", address=").append(address).append("]");
		return builder.toString();
	}

}
