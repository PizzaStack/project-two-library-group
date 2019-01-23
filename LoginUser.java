package com.revature.LibraryCatalog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loginuser")
public class LoginUser {
	@Id
	private int id;
	private int libraryUserID;
	private String username;
	private String password;
	private boolean isLibrarian;
	
	public LoginUser(int id, int libraryUserID, String username, String password, boolean isLibrarian) {
		super();
		this.id = id;
		this.libraryUserID = libraryUserID;
		this.username = username;
		this.password = password;
		this.isLibrarian = isLibrarian;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLibraryUserID() {
		return libraryUserID;
	}
	public void setLibraryUserID(int libraryUserID) {
		this.libraryUserID = libraryUserID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLibrarian() {
		return isLibrarian;
	}
	public void setLibrarian(boolean isLibrarian) {
		this.isLibrarian = isLibrarian;
	}
	
	

}
