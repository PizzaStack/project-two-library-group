package com.revature.LibraryCatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.LibraryCatalog.entity.Keyword;
import com.revature.LibraryCatalog.dao.KeywordDao;

@RestController
public class KeywordController {
	@Autowired
	KeywordDao dao;
	
	@GetMapping("/keyword/{value}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Keyword findBookByValue(@PathVariable("value") String value) {
		return dao.findByValue(value);
	}
	
}
