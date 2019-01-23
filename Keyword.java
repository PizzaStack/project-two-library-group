package com.revature.LibraryCatalog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "keywrod")
public class Keyword {
	
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
