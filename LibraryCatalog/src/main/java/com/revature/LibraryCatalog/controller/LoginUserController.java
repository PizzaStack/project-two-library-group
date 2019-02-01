package com.revature.LibraryCatalog.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.LibraryCatalog.dao.LibrarianDao;
import com.revature.LibraryCatalog.dao.LoginUserDao;
import com.revature.LibraryCatalog.dao.PatronDao;
import com.revature.LibraryCatalog.entity.LoginUser;

@RestController
public class LoginUserController {

	@Autowired
	LoginUserDao dao;
	@Autowired
	PatronDao pDao;
	@Autowired
	LibrarianDao lDao;
	
	
	@GetMapping("/LoginUser/{username}/{password}")
	@CrossOrigin(origins = "http://localhost.4200")
	public Object logUserIn(@PathVariable("username") String username, @PathVariable("password") String password,
			HttpSession session) {
		LoginUser lu = dao.getByUsernameAndPassword(username, password);
		if(lu == null) {
			return "User does not exist";
		}
		else {
			session.setAttribute("userID", lu.getLibraryUserID());
			session.setAttribute("username", lu.getLibraryUserID());
			session.setAttribute("password", lu.getPassword());
			session.setAttribute("isLibrarian", lu.isLibrarian());
			return lu;
		}
		
	}
	@GetMapping("/LoginUser/Logout")
	@CrossOrigin(origins = "http://localhost.4200")
	public LoginUser logUserOut(HttpSession session) {
		session.invalidate();
		return dao.getById(12);
		
	}
	@GetMapping("/LoginUser/Info")
	@CrossOrigin(origins = "http://localhost.4200")
	public Object getUserInformation(HttpSession session){
		int userID = 0;
		userID = (int) session.getAttribute("userID");
		if((boolean) session.getAttribute("isLibrarian")) {
			return lDao.GetLibrarianInfo(userID);
		}
		else {
			return pDao.GetPatronInfo(userID);
		}
	}
	
	
}
