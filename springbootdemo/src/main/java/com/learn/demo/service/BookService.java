package com.learn.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.demo.dao.BookDao;
import com.learn.demo.entity.Book;

@Service
public class BookService implements BookServiceImpl{
	@Autowired
	private BookDao bookDao;
	
	
	@Override
	public List<Book> getAllBookDetails() {
		return bookDao.findAll();
	}


	@Override
	public Optional<Book> getBookById(Long bookId) {
		
		return bookDao.findById(bookId);
	}


	@Override
	public Book addBookDetails(Book book) {
		return bookDao.save(book);
	}


	@Override
	public Book updateBookDetail(Long bookId, Book book) {
		Optional<Book> bookid = bookDao.findById(bookId);
		if(bookid.isPresent()) {
			Book book1 = bookid.get();
			book1.setBookTitle(book.getBookTitle());
			book1.setBookCategory(book.getBookCategory());
			book1.setBookGenre(book.getBookGenre());
			book1.setBookPrice(book.getBookPrice());
			
			return bookDao.save(book1);
		}
		else {
			System.out.println("no data updated");
			 return null;
		}
			
		
	}


	@Override
	public String deleteBookDetail(Long bookId) {
		String message;
		Optional optionalbookid = bookDao.findById(bookId);
		if(optionalbookid.isPresent()) {
			bookDao.deleteById(bookId);
			message = "book deleted sucessfully :)";
		}
		else {
			message = "book not deleted due unavaliable in database :(";
		}
		
		return message;
	}

}
