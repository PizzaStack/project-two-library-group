package com.revature.LibraryCatalog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.LibraryCatalog.entity.Book;
import com.revature.LibraryCatalog.entity.Librarian;

public interface LibrarianDao extends JpaRepository<Librarian, Integer> {
	@Query("select l.firstName, l.lastName, lu.username, lu.password, l.librarianID  "
			+ "FROM Librarian l JOIN LoginUser lu ON l.librarianID = lu.userID WHERE l.librarianID = :librarianID")
	public Object GetLibrarianInfo(@Param("librarianID")int librarianID);
	
	public Librarian getBylibrarianID(@Param("librarianID")int librarianID);
}
