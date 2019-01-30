package com.revature.LibraryCatalog.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "book")
public class Book {
	private static final String TemporalType = null;
	@Id
	private int bookID;
	@Column(name = "title")
	private String title;
	private String author;
	private long ibsn;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "keyword1")
	private Keyword keyword1;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "keyword2")
	private Keyword keyword2;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "keyword3")
	private Keyword keyword3;
	@Column(name = "coverimageurl")
	private String coverimageurl;
	@Column(name = "description")
	private String description;
/*	@Column(name = "patronid")
	private int patron_ID;*/

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "patronid")
	private Patron patron;
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date datecheckedout;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookID, String title, String author, long ibsn, Keyword keyword1, Keyword keyword2, Keyword keyword3,
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
		//this.patron = patron;
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
	public long getIBSN() {
		return ibsn;
	}

	public void setIBSN(long ibsn) {
		this.ibsn = ibsn;
	}
	public Keyword getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(Keyword keyword1) {
		this.keyword1 = keyword1;
	}
	public Keyword getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(Keyword keyword2) {
		this.keyword2 = keyword2;
	}
	public Keyword getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(Keyword keyword3) {
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
	public Patron getPatron() {
		return patron;
	}

	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	public Date getDatecheckedout() {
		return datecheckedout;
	}

	public void setDatecheckedout(Date datecheckedout) {
		this.datecheckedout = datecheckedout;
	}

	

}
