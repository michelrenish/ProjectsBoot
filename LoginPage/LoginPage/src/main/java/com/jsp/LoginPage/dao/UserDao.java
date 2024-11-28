package com.jsp.LoginPage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.LoginPage.entity.UserDetails;
import com.jsp.LoginPage.repository.UserRepo;

@Repository
public class UserDao {
	@Autowired
	 private UserRepo repo;
	
	public UserDetails saveUser(UserDetails user) {
		return repo.save(user);
	}
	public UserDetails loginById(String uid,String password ) {
		return repo.loginById(uid,password);
	}
	public UserDetails loginByMail(String uemail,String password ) {
		return repo.loginByMail(uemail, password);
	}
}
