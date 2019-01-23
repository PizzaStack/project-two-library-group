package com.revature.LibraryCatalog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "librarian")
public class Librarian {

	@Id
	private int librarianID;
	private String firstName;
	private String lastName;
	
	public Librarian(int librarianID, String firstName, String lastName) {
		super();
		this.librarianID = librarianID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getLibrarianID() {
		return librarianID;
	}
	public void setLibrarianID(int librarianID) {
		this.librarianID = librarianID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
