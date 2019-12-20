package com.briup.bean;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Category {
	private Integer id;
	private String name;//类别
	private String description;//介绍
	private List<Category> category;//子分类
	
	
	public Category() {}
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public Category(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [id=").append(id).append(", name=").append(name).append(", description=")
				.append(description).append(", category=").append(category)
				.append("]");
		return builder.toString();
	}

	

}
