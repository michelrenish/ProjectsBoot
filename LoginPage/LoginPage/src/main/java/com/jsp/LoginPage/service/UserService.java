package com.jsp.LoginPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.LoginPage.Util.ResponceStructur;
import com.jsp.LoginPage.dao.UserDao;
import com.jsp.LoginPage.entity.UserDetails;
import com.jsp.LoginPage.exeption.UserGivenIdNotFound;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponceStructur<UserDetails>> saveUser(UserDetails user) {
		ResponceStructur<UserDetails> rs = new ResponceStructur<UserDetails>();
		dao.saveUser(user);
		rs.setMessage("UserDetails are saved");
		rs.setCode(201);
		rs.setData(user);
		return new ResponseEntity<ResponceStructur<UserDetails>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponceStructur<UserDetails>> login(String uid, String uemail, String password) {
		UserDetails us = dao.loginById(uid, password);
		UserDetails us1 = dao.loginByMail(uemail, password);
		ResponceStructur<UserDetails> rs = new ResponceStructur<UserDetails>();
		if (uid != null && us != null) {
			rs.setMessage("Welcome to your Login");
			rs.setCode(HttpStatus.FOUND.value());
			rs.setData(dao.loginById(uid, password));
			return new ResponseEntity<ResponceStructur<UserDetails>>(rs, HttpStatus.FOUND);
		} else if (uemail != null && us1 != null) {
			rs.setMessage("Welcome to your Login");
			rs.setCode(HttpStatus.FOUND.value());
			rs.setData(dao.loginByMail(uemail, password));
			return new ResponseEntity<ResponceStructur<UserDetails>>(rs, HttpStatus.FOUND);
		} else {
			throw new UserGivenIdNotFound();
		}
	}
}
