package com.revature.LibraryCatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.LibraryCatalog.dao.LibrarianDao;

@RestController
public class LibrarianController {
	
	@Autowired
	LibrarianDao dao;
	
	@GetMapping("/Librarian/{librarianID}")
	public Object GetLibrarianInformation(@PathVariable("librarianID") int librarianID){
		return dao.GetLibrarianInfo(librarianID);
	}

}
