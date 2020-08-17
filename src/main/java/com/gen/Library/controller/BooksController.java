package com.gen.Library.controller;

import com.gen.Library.model.Books;
import com.gen.Library.repository.BookRepository;
import com.gen.Library.service.BookService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class BooksController {


	@Autowired
	BookService bookService;

	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping("/books")
	public ResponseEntity<String> createBooksToDB(@RequestBody Books books) {
		try {
			boolean createSuccess = this.bookService.createBooks(books);
			if (createSuccess) {
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}
		
		catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}
  

	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> deleteBooksFromDB(@PathVariable("id") String id) {
		try {
			boolean deleteSuccess = false;
			deleteSuccess =	this.bookService.deleteBooks(id);
			if (deleteSuccess) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Books> updateBooksFromDB(@RequestBody Books books, @PathVariable("id") String id) throws Exception{
		
		Books updateSuccess = this.bookService.updateBooks(books, id);
			if (updateSuccess != null) {
				return new ResponseEntity<Books>(updateSuccess,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/books/{id}")
	public ResponseEntity<String> getAllBooksByIdFromDb(@PathVariable("userId") String userId,@PathVariable("id") String id) {
		try {
		
			Books books = this.bookService.getBooksById(id);
			
			if(books != null) {
				return new ResponseEntity(books,HttpStatus.OK);
			}
			else {
				return new ResponseEntity(books,HttpStatus.NOT_FOUND);
			}
			
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		
	}

}
