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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.LibraryCatalog.entity.Book;
import com.revature.LibraryCatalog.entity.Keyword;
import com.revature.LibraryCatalog.entity.Patron;
import com.google.gson.Gson;
import com.revature.LibraryCatalog.dao.BookDao;
import com.revature.LibraryCatalog.dao.KeywordDao;
import com.revature.LibraryCatalog.dao.LoginUserDao;
import com.revature.LibraryCatalog.dao.PatronDao;

@RestController
public class BookController {
	@Autowired
	BookDao dao;
	@Autowired
	PatronDao pDao;
	@Autowired
	LoginUserDao luDao;
	
	@GetMapping("/Book/title/{title}")
	@CrossOrigin(origins = "http://localhost.4200")
	public Object findBookByTitle(@PathVariable("title") String title) {
		Book book = dao.findByTitle(title);
		if(book == null) {
			return "No matching books found";
		}
		return book;
	}
	@GetMapping("/Book/author/{author}")
	@CrossOrigin(origins = "http://localhost.4200")
	public Object findBookByAuthor(@PathVariable("author")String author) {
		Book book =  dao.findByAuthor(author);
		if(book == null) {
			return "No Maching books found";
		}
		return book;
	}
	@GetMapping("Book/parameter/{parameter}")
	@CrossOrigin(origins = "http://localhost.4200")
	public Object findBooksByParameter(@PathVariable("parameter")String parameter){
		List<Book> books = dao.getBooksByParamter(parameter);
		if(books.isEmpty()) {
			return "Sorry no books where found with matching criteria";
		}
		else {
			Date date = getLibraryStartDate();
			for(Book book: books) {
				if(book.getDatecheckedout().before(date)) {
					book.setDatecheckedout(null);
				}
			}
			return books;
		}
		
	}
	
	@GetMapping("Book/LoggedInPatron")
	@CrossOrigin(origins = "http://localhost.4200")
	public String getBooksByLoggedInUser(HttpSession session ){
		int patronID = (int) session.getAttribute("userID");
		List<Book>books =  dao.getBooksByLoggedInPatron(patronID);
		if(books.isEmpty()) {
			return "You don't have any books that are not checked out";
		}
		for(Book book: books) {
			book.setPatron(null);
		}
		Gson gson = new Gson();
		return gson.toJson(books);
	}
	@GetMapping("Book/Patron/{patronUsername}")
	@CrossOrigin(origins = "http://localhost.4200")
	public String getBooksByPatronUsername(@PathVariable("patronUsername")String patronUsername) {
		int patronID = luDao.getUserIdByUsername(patronUsername);
		List<Book>books =  dao.getBooksByLoggedInPatron(patronID);
		if(books.isEmpty()) {
			return "This patron doesn't have any books checked out";
		}
		for(Book book: books) {
			book.setPatron(null);
		}
		Gson gson = new Gson();
		return gson.toJson(books);
	}
	
	@GetMapping("Book/Checkout/{title}")
	@CrossOrigin(origins = "http://localhost.4200")
	public String checkOutBook(@PathVariable("title")String title, HttpSession session) {
		Book book = dao.findByTitle(title);
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Date date = getLibraryStartDate();
		if(book == null || book.getDatecheckedout().after(date)) {
			return "Sorry, that book is not available for checkout.";
		}
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		try {
			date = format.parse(timeStamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int patronID = (int) session.getAttribute("userID");
		Patron patron = pDao.findByPatronID(patronID);
		book.setPatron(patron);
		book.setDatecheckedout( java.sql.Date.valueOf(timeStamp));
		dao.save(book);
		return "Your book was successfully checked out.";
	}
	@GetMapping("Book/Return/{title}")
	@CrossOrigin(origins = "http://localhost.4200")
	public String ReturnBook(@PathVariable("title")String title) {
		Book book = dao.findByTitle(title);
		Date date = getLibraryStartDate();
		
		if(book == null ) {
			return "This book doesn't exist in the library database";
		}
		if(book.getDatecheckedout().before(date)) {
			return "This book is already currently in the library catalog";
		}
		book.setDatecheckedout(date);
		book.setPatron(pDao.findByPatronID(0));
		dao.save(book);
		return "Book was successfully returned";
	}
	@GetMapping("Book/GetBooksCheckedOut")
	@CrossOrigin(origins = "http://localhost.4200")
	public String getBooksCheckedOut() {
		List<Book> books = dao.getBooksCheckedOut();
		for(Book book: books) {
			book.setDescription(null);
		}
		Gson gson = new Gson();
		return gson.toJson(books);
	}
	public Date getLibraryStartDate() {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Date date = new Date();
		String dateInString = "02-10-2018";
		try {
			 date = format.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/*@GetMapping("/book{keyword}")
	public ArrayList<Book> findBooksByKeyword(@PathVariable("Keyword") String keyworkd){
		return 
	}*/
}
