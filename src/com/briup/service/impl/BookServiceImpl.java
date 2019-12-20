package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.briup.bean.Book;
import com.briup.dao.BookDao;
import com.briup.dao.CategoryDao;
import com.briup.exception.BookException;
import com.briup.service.IBookService;
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class BookServiceImpl implements IBookService {
	@Autowired
	private BookDao dao;
	@Autowired
	private CategoryDao dao2;
	@Override
	public List<Book> getBooks(Integer categoryId) throws BookException{
		List<Book> books = null;
		try {
			if (categoryId == null) {
				throw new Exception("查询失败");
			}else {
				books = dao.findBookBycategoryId(categoryId);
			}
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}
		
		return books;
	}

	@Override
	public String getFatherName(int id) throws BookException {
		String name = null;
		try {
			int categoryId = dao2.findFatherId(id);
			name = dao2.findFatherName(categoryId);
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}
		return name;
	}

	@Override
	public String getKidName(int id) throws BookException {
		String name = null;
		try {
			name = dao2.findKidName(id);
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}
		return name;
	}

	@Override
	public Book getBook(int id) throws BookException {
		Book book = null;
		try {
			book = dao.findBookById(id);
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}
		return book;
	}

	@Override
	public void updateBookKuc(int num, Book book) throws BookException {
		dao.updateBook(num, book.getBookId());
	}
	
}
