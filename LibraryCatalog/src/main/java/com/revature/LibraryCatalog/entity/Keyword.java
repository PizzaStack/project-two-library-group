package com.revature.LibraryCatalog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "keyword")
public class Keyword {
	
	public Keyword() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private int keywordID;
	private String value;
	
	
	public Keyword(int keywordID, String value) {
		super();
		this.keywordID = keywordID;
		this.value = value;
	}
	
	public int getKeywordID() {
		return keywordID;
	}
	public void setKeywordID(int keywordID) {
		this.keywordID = keywordID;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
