package com.briup.dao;

import java.util.List;

import com.briup.bean.Book;

public interface BookDao {
	// 通过小种类查询图书
	public List<Book> findBookBycategoryId(Integer categoryId);
	
	// 通过图书Id查询图书对象
	public Book findBookById(int id);
	
	// 更新图书库存
	public void updateBook(int num,int bookId);
}
