package com.revature.LibraryCatalog.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.LibraryCatalog.entity.Patron;

public interface PatronDao extends JpaRepository<Patron, Integer> {
	@Query("select p from Patron p where p.patronID > 0")
	public List<Patron> findAll();
	
	@Query("select p.firstName, p.lastName, lu.username, lu.password, p.address, p.phoneNumber, p.emailAddress  "
			+ "FROM Patron p JOIN LoginUser lu ON p.patronID = lu.userID WHERE p.patronID = :patronID")
	public Object GetPatronInfo(int patronID);
	
	@Query("select p from Patron p where p.patronID=:id")
	public Patron findByPatronID(int id);
	
	}

