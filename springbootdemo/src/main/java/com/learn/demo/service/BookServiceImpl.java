package com.learn.demo.service;

import java.util.List;
import java.util.Optional;

import com.learn.demo.entity.Book;

public interface BookServiceImpl {
	
	abstract public List<Book> getAllBookDetails();
	abstract public Optional<Book> getBookById(Long bookId);
	abstract public Book addBookDetails(Book book);
	abstract public Book updateBookDetail(Long bookId, Book book);
	abstract public String deleteBookDetail(Long bookId);

}
