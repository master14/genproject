package com.gen.Library.service;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.Library.model.Books;
import com.gen.Library.repository.BookRepository;


@Service
public class BookServiceImpl implements BookService {

	
	@Autowired
	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public boolean createBooks(Books books) throws Exception {
		Books createSuccess = this.bookRepository.findAll().get(0);
		if (createSuccess != null) {
			createSuccess.getAuthor();
			this.bookRepository.save(createSuccess);
		} else {
			this.bookRepository.save(books);
		}
		return true;
	}

	public boolean deleteBooks(String id) throws Exception   {
		try {
			Books booksDetails = this.bookRepository.findById(id).get();
			if (booksDetails != null) {
				this.bookRepository.deleteById(id);
				return true;
			} else {
				throw new Exception("player not found");
			}
		} catch (Exception e) {
			throw new Exception("player issue to delete");
		}
	}


	public Books updateBooks(Books books, String id) throws Exception {

		Optional<Books> DetailsOpt = this.bookRepository.findById(id);
		try {
			//Books booksDetails = this.bookRepository.findById(id).get();
			if (DetailsOpt != null) {
				this.bookRepository.deleteById(id);
				return DetailsOpt.get();
			} else {
				throw new Exception("books not found");
			}
		} catch (Exception e) {
			throw new Exception("books issue to delete");
		}
	}

	public Books getBooksById(String id) throws Exception {
		try {
			Optional<Books> bookDetails = this.bookRepository.findById(id);
			if (bookDetails.isPresent()) {
				return bookDetails.get();
			} else {
				throw new NoSuchElementException();
			}
		} catch (Exception e) {
			throw new Exception("books not found");
		}

	}



}
