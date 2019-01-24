package com.revature.LibraryCatalog;
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
	private String firstName;
	private String lastName;
	private String address;
	private long phoneNumber;
	private String emailAddress;
	
	public Patron(int patronID, String firstName, String lastName, String address, long phoneNumber, String emailAddress) {
		this.patronID = patronID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
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
	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}
	@Column(name = "phoneNumber")
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name = "emailaddress")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
