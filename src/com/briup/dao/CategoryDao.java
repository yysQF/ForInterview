package com.briup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.briup.bean.Category;

public interface CategoryDao {
	// 只查询大分类
	public List<Category> findFatherCategories();
	
	// 查询大分类通过小分类Id
	public int findFatherId(int id);
	
	// 查询大分类的名字name
	public String findFatherName(int id);
	
	//查询小种类的名字
	public String findKidName(int id);
	
	// 级联查询小分类
	public List<Category> findAllCategories();
}
