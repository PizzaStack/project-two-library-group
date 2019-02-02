package com.revature.LibraryCatalog.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.LibraryCatalog.entity.LoginUser;

public interface LoginUserDao extends JpaRepository<LoginUser, Integer> {
	
	@Query("Select lu from LoginUser lu where lu.username = :username and lu.password = :password ")
	public LoginUser getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	public LoginUser getById(@Param("id")int id);
	public LoginUser getByUserID(@Param("id")int id);
	
	@Query("SELECT MAX(lu.id) FROM LoginUser lu")
	public int getMaxId();
	@Query("SELECT MAX(lu.userID) FROM LoginUser lu")
	public int getMaxUserId();
	
	@Query("Select lu.userID from LoginUser lu where lu.username = :username")
	public int getUserIdByUsername(@Param("username")String username);
	
	
}
