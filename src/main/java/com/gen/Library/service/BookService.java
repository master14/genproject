package com.gen.Library.service;


import java.util.List;

import com.gen.Library.model.Books;


public interface BookService {
	
    boolean createBooks(Books books) throws Exception;

    boolean deleteBooks(String id) throws Exception;

    Books updateBooks(Books books, String id) throws Exception;

    Books getBooksById(String id) throws Exception;

}
