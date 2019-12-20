package com.briup.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	private Integer bookId;
	private String name;
	private Double price;//价钱
	private String author;//作者
	private String publisher;//出版社
	private Date pubDate;//出版时间
	private String description;//介绍
	private Integer categoryId;//类别
	private Integer kuc; // 库存
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Book() {
	}
	public Book(Integer bookId, String name, Double price, String author, String publisher, Date pubDate,
			String description, Integer categoryId) {
		this.bookId = bookId;
		this.name = name;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.pubDate = pubDate;
		this.description = description;
		this.categoryId = categoryId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubDate() {
		return sdf.format(pubDate);
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public Integer getKuc() {
		return kuc;
	}
	public void setKuc(Integer kuc) {
		this.kuc = kuc;
	}
	public Book(Integer bookId, String name, Double price, String author, String publisher, Date pubDate,
			String description, Integer categoryId, Integer kuc) {
		this.bookId = bookId;
		this.name = name;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.pubDate = pubDate;
		this.description = description;
		this.categoryId = categoryId;
		this.kuc = kuc;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [bookId=").append(bookId).append(", name=").append(name).append(", price=").append(price)
				.append(", author=").append(author).append(", publisher=").append(publisher).append(", pubDate=")
				.append(pubDate).append(", description=").append(description).append(", categoryId=").append(categoryId)
				.append(", kuc=").append(kuc).append("]");
		return builder.toString();
	}
	
	
	
	
}
