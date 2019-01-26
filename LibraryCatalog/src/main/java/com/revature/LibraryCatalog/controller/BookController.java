package com.revature.LibraryCatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.LibraryCatalog.entity.Book;
import com.revature.LibraryCatalog.entity.Keyword;
import com.revature.LibraryCatalog.dao.BookDao;
import com.revature.LibraryCatalog.dao.KeywordDao;

@RestController
public class BookController {
	@Autowired
	BookDao dao;
	
	@GetMapping("/{title}")
	public Book findBookByValue(@PathVariable("title") String title) {
		return dao.findByTitle(title);
	}
	
	/*@GetMapping("/book{keyword}")
	public ArrayList<Book> findBooksByKeyword(@PathVariable("Keyword") String keyworkd){
		return 
	}*/
}
