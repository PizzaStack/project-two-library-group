package com.revature.LibraryCatalog.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import com.google.gson.Gson;
import com.revature.LibraryCatalog.dao.BookDao;
import com.revature.LibraryCatalog.dao.KeywordDao;
import com.revature.LibraryCatalog.dao.PatronDao;

@RestController
public class BookController {
	@Autowired
	BookDao dao;
	PatronDao pDao;
	
	@GetMapping("/Book/{title}")
	public Book findBookByTitle(@PathVariable("title") String title) {
		return dao.findByTitle(title);
	}
	@GetMapping("/Book/author/{author}")
	public Book findBookByAuthor(@PathVariable("author")String author) {
		return dao.findByAuthor(author);
	}
	@GetMapping("Book/LoggedInPatron")
	public String getBooksByLoggedInUser(HttpSession session ){
		int patronID = (int) session.getAttribute("userID");
		List<Book>books =  dao.getBooksByLoggedInPatron(patronID);
		for(Book book: books) {
			book.setPatron(null);
		}
		Gson gson = new Gson();
		String jsonBooks = gson.toJson(books);
		return jsonBooks;
		
	}
	@GetMapping("Book/Checkout/{title}")
	public String checkOutBook(@PathVariable("title")String title, HttpSession session) {
		Book book = dao.findByTitle(title);
		if(book == null) {
			return "Sorry that book is not available for checkout";
		}
		

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = null;
		try {
			date = format.parse(timeStamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Something went wrong";
		}
		book.setDatecheckedout(date);
		int patronID = (int) session.getAttribute("userID");
		book.setPatron(pDao.findById(patronID));
		return "Your book was successfully submitted";
		
	}
	
	/*@GetMapping("/book{keyword}")
	public ArrayList<Book> findBooksByKeyword(@PathVariable("Keyword") String keyworkd){
		return 
	}*/
}
