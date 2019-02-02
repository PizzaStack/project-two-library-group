package com.revature.LibraryCatalog.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
import com.revature.LibraryCatalog.entity.Librarian;
import com.revature.LibraryCatalog.entity.LoginUser;
import com.revature.LibraryCatalog.entity.Patron;
import com.revature.LibraryCatalog.dao.BookDao;
import com.revature.LibraryCatalog.dao.LoginUserDao;
import com.revature.LibraryCatalog.dao.PatronDao;

@RestController
public class PatronController {
	@Autowired
	PatronDao dao;
	@Autowired
	LoginUserDao luDao;
	
	@GetMapping("/Patrons")
	@CrossOrigin(origins = "http://localhost:4200")
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
	@CrossOrigin(origins = "http://localhost:4200")
		public Patron getPatron(@PathVariable("patronID")int patronID) {
			return dao.findByPatronID(patronID);
		}
	@GetMapping("/Patrons/CreateNewPatron/{username}/{password}/{firstName}/{lastName}/{phoneNumber}/{address}/{emailAddress}")
	@CrossOrigin(origins = "http://localhost:4200")
		public String createPatron(@PathVariable("username")String username, @PathVariable("password")String password,
				@PathVariable("firstName")String firstName, @PathVariable("lastName") String lastName, 
				@PathVariable("phoneNumber")Long phoneNumber, @PathVariable("address") String address,
				@PathVariable("emailAddress")String emailAddress) {
			
			int maxID = luDao.getMaxId() +1 ;
			int maxUserID = luDao.getMaxUserId() +1;
			String response = "";
			try {
				LoginUser loginUser = new LoginUser(maxID, maxUserID, username, password, false);
				Patron patron = new Patron(maxUserID, firstName, lastName, address, phoneNumber, emailAddress);
				EntityManagerFactory emf = Persistence.createEntityManagerFactory( "persistenceUnitName");
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(loginUser);
				em.persist(patron);
				em.getTransaction().commit();
				em.close();
				response = "Patron has been created";
			}
			catch(Exception ex) {
				response = "Failed to create patron account";
			}
			return response;
	}
	@GetMapping("/Patrons/UpdatePatronInfo/{username}/{password}/{firstname}/{lastname}/{phoneNumber}/{address}/{emailAddress}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String updatePatronUserInfo(@PathVariable("username")String username, @PathVariable("password")String password,
			@PathVariable("firstName")String firstName, @PathVariable("lastName") String lastName, 
			@PathVariable("phoneNumber")Long phoneNumber, @PathVariable("address") String address,
			@PathVariable("emailAddress")String emailAddress, HttpSession session) {
		
		int patronID = (int) session.getAttribute("userID");
		Patron patron = dao.findByPatronID(patronID);
		patron.setFirstName(firstName);
		patron.setLastName(lastName);
		patron.setPhoneNumber(phoneNumber);
		patron.setAddress(address);
		patron.setEmailAddress(emailAddress);
		dao.save(patron);
		LoginUser loginUser = luDao.getByUserID(patronID);
		loginUser.setUsername(username);
		loginUser.setPassword(password);
		luDao.save(loginUser);
		return "Patron Information has been updated";
	}
}
	
