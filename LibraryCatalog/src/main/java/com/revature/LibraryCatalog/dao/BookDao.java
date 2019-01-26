package com.revature.LibraryCatalog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.LibraryCatalog.entity.Book;



@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
	
	Book findByTitle(String title);
	
/*	@Transactional
	ArrayList<Book> findBooksByKeywor(String keyword){
		ArrayList<Book> 
	*///}

}