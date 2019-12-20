package com.briup.bean;
/*
 * 		一个用户有一个默认地址，但是可以有多个收货地址。
 */
public class Address {
	Integer id;
	String country;
	String city;
	String street;
	Customer customer;

	public Address() {

	}

	public Address(String addr) {
		String[] split = addr.split("-");
		country = split[0];
		city = split[1];
		street = split[2];
	}
	
	public Address(Integer id, String country, String city, String street) {
		this.id = id;
		this.country = country;
		this.city = city;
		this.street = street;
	}

	public Address(String country, String city, String street) {
		this.country = country;
		this.city = city;
		this.street = street;
	}
	
	public Address(String country, String city, String street, Customer customer) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.customer = customer;
	}

	public String getAsString() {
		
		return country+"-"+city+"-"+street;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [Id=").append(id).append(", country=").append(country).append(", city=")
				.append(city).append(", street=").append(street).append("]");
		return builder.toString();
	}
	

}
