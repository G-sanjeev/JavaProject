package com.learn.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.demo.entity.Book;
import com.learn.demo.service.BookServiceImpl;

@RestController
public class BookContorller {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
//	implementing the get all book details list 
	
	@GetMapping("/books")
	public List<Book> getAllBookDetails(){
		
		return bookServiceImpl.getAllBookDetails();
	}

	// implemented to get book by id 
	
	@GetMapping("/books/{bookId}")
	public Optional<Book> getBookById(@PathVariable Long bookId){
		return bookServiceImpl.getBookById(bookId);
	}
	
	// implementing to add book 
	
	@PostMapping("/books")
	public Book addBookDetails(@RequestBody Book book) {
		return bookServiceImpl.addBookDetails(book);
	}
	
	// implementing put method
	@PutMapping("/books/{bookId}")
	public Book updateBookDetail(@PathVariable Long bookId, @RequestBody Book book) {
		return bookServiceImpl.updateBookDetail(bookId, book);
	}
	
	//implementing delete method
	
	@DeleteMapping("/books/{bookId}")
	public String deleteBookDetail(@PathVariable Long bookId) {
		return bookServiceImpl.deleteBookDetail(bookId);
	}
}
