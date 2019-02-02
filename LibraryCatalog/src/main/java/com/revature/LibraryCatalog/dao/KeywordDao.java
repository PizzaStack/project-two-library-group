package com.revature.LibraryCatalog.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.LibraryCatalog.entity.Keyword;

public interface KeywordDao extends JpaRepository<Keyword, Integer> {

		Keyword findByValue(@Param("value")String value);
	
}