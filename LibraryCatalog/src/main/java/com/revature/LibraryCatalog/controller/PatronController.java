package com.revature.LibraryCatalog.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.LibraryCatalog.entity.Book;
import com.revature.LibraryCatalog.entity.Patron;
import com.revature.LibraryCatalog.dao.BookDao;
import com.revature.LibraryCatalog.dao.PatronDao;

@RestController
public class PatronController {
	@Autowired
	PatronDao dao;
	
	@GetMapping("/Patrons")
	public List<Patron> getAll(){
		return dao.findAll();
	}
	/*@GetMapping("/Patron/{patronID}")
	public Object getPatronInformation(@PathVariable("patronID") int patronID) {

	    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "persistenceUnitName");
		EntityManager em = emf.createEntityManager();
		String query = "select p.firstName, p.lastName, lu.username, lu.password, p.address, p.phoneNumber, p.emailAddress  "
		+ "FROM Patron p JOIN LoginUser lu ON p.patronID = lu.userID WHERE p.patronID =" + patronID;
		em.getTransaction().begin();	
		List<Object[]> patronInformation = em.createQuery(query).getResultList();
		em.getTransaction().commit();
		em.close();
		
		return patronInformation;
	}*/
	@GetMapping("/Patrons/{patronID}")
		public Patron getPatron(@PathVariable("patronID")int patronID) {
			return dao.findByPatronID(patronID);
		}
	}
	
