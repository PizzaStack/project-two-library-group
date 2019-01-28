package com.revature.LibraryCatalog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	@GetMapping("/Book/{title}")
	public Book findBookByTitle(@PathVariable("title") String title) {
		return dao.findByTitle(title);
	}
	@GetMapping("/Book/author/{author}")
	public Book findBookByAuthor(@PathVariable("author")String author) {
		return dao.findByAuthor(author);
	}
	@GetMapping("Book/LoggedInPatron")
	public List<Book> getBooksByLoggedInUser(HttpSession session ){
		int patronID = (int) session.getAttribute("userID");
		List<Book>books =  dao.getBooksByLoggedInPatron(patronID);
		for(Book book: books) {
			book.setPatron(null);
		}
		return books;
		
	}
	
	/*@GetMapping("/book{keyword}")
	public ArrayList<Book> findBooksByKeyword(@PathVariable("Keyword") String keyworkd){
		return 
	}*/
}
