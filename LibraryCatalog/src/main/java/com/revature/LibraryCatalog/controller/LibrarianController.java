package com.revature.LibraryCatalog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.LibraryCatalog.dao.LibrarianDao;
import com.revature.LibraryCatalog.dao.LoginUserDao;
import com.revature.LibraryCatalog.entity.Librarian;
import com.revature.LibraryCatalog.entity.LoginUser;

@RestController
public class LibrarianController {
	
	@Autowired
	LibrarianDao dao;
	@Autowired
	LoginUserDao luDao;
	
	@GetMapping("/Librarian/{librarianID}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Object GetLibrarianInformation(@PathVariable("librarianID") int librarianID){
		return dao.GetLibrarianInfo(librarianID);
	}
	@GetMapping("/LoginUser/UpdateLibrarianInfo/{username}/{password}/{firstName}/{lastName}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String updateLibraryUserInfo(@PathVariable("username") String username, @PathVariable("password") String password,
			@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, HttpSession session) {
			int librarianID = (int) session.getAttribute("userID");
			Librarian librarian = dao.getBylibrarianID(librarianID);
			librarian.setFirstName(firstName);
			librarian.setLastName(lastName);
			dao.save(librarian);
			LoginUser loginUser = luDao.getByUserID(librarianID);
			loginUser.setUsername(username);
			loginUser.setPassword(password);
			luDao.save(loginUser);
			return "Libarian Information has been updated";
	}

}
