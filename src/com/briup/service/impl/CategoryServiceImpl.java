package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Category;
import com.briup.dao.CategoryDao;
import com.briup.service.ICategoryService;
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private CategoryDao CategoryDao;
	
	@Override
	public List<Category> getCategories() {
		
		return CategoryDao.findFatherCategories();
	}

}
