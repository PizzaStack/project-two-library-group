package com.revature.LibraryCatalog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
	private int bookID;
	private String title;
	private String author;
	private int ibsn;
	private int keyword1;
	private int keyword2;
	private int keyword3;
	private String coverimageurl;
	private String description;
	
	public Book(int bookID, String title, String author, int ibsn, int keyword1, int keyword2, int keyword3,
			String coverimageurl, String description) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.ibsn = ibsn;
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.keyword3 = keyword3;
		this.coverimageurl = coverimageurl;
		this.description = description;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getIBSN() {
		return ibsn;
	}

	public void setIBSN(int ibsn) {
		ibsn = ibsn;
	}

	public int getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(int keyword1) {
		this.keyword1 = keyword1;
	}

	public int getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(int keyword2) {
		this.keyword2 = keyword2;
	}

	public int getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(int keyword3) {
		this.keyword3 = keyword3;
	}

	public String getCoverimageurl() {
		return coverimageurl;
	}

	public void setCoverimageurl(String coverimageurl) {
		this.coverimageurl = coverimageurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
