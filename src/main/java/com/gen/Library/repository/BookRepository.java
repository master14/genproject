package com.gen.Library.repository;

import com.gen.Library.model.Books;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, String> {
	
}