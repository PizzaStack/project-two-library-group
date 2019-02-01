package com.revature.LibraryCatalog.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.LibraryCatalog.entity.Book;



@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
	
	Book findByTitle(String title);
	Book findByAuthor(String author);
	
	@Query("select b from Book b where b.title = :parameter or b.author = :parameter or b.keyword1.value = :parameter or b.keyword2.value = :parameter"
			+ " or b.keyword3.value = :parameter")
	List<Book> getBooksByParamter(String parameter);
	
	@Query("select b from Book b where b.patron.patronID = :patronID")
	List<Book> getBooksByLoggedInPatron(int patronID);
	
	@Query("select b from Book b where b.patron.patronID > 0")
	List<Book> getBooksCheckedOut();
	
	
/*	@Transactional
	ArrayList<Book> findBooksByKeywor(String keyword){
		ArrayList<Book> 
	*///}

}