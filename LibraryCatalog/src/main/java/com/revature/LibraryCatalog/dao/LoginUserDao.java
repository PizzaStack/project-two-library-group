package com.revature.LibraryCatalog.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.LibraryCatalog.entity.LoginUser;

public interface LoginUserDao extends JpaRepository<LoginUser, Integer> {

}
