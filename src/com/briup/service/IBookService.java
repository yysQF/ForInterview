package com.briup.service;

import java.util.List;

import com.briup.bean.Book;
import com.briup.exception.BookException;

public interface IBookService {
	// 查询图书父级 子级
	public String getFatherName(int id)throws BookException;
	public String getKidName(int id) throws BookException;
	// 查询图书列表
	public List<Book> getBooks(Integer categoryId) throws BookException;
	
	// 查询图书对象
	public Book getBook(int id) throws BookException;
	
	// 更新库存
	public void updateBookKuc(int num,Book book) throws BookException;
}
