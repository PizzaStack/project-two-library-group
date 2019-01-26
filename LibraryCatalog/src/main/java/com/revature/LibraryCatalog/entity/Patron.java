package com.revature.LibraryCatalog.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "patron")
public class Patron implements Serializable {

	@Id
	private int patronID;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	private String address;
	@Column(name = "phonenumber")
	private long phoneNumber;
	@Column(name = "emailaddress")
	private String emailAddress;
	
	public Patron(int patronID, String firstName, String lastName, String address, long phoneNumber, String emailAddress) {
		this.patronID = patronID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	public Patron() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int patronID() {
		return patronID;
	}

	public void setPatronID(int patronID) {
		this.patronID = patronID;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
