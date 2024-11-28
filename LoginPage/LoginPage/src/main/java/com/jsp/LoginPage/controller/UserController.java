package com.jsp.LoginPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.LoginPage.Util.ResponceStructur;
import com.jsp.LoginPage.entity.UserDetails;
import com.jsp.LoginPage.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/saveUser")
	public ResponseEntity<ResponceStructur<UserDetails>> saveUser(@RequestBody UserDetails user){
		return service.saveUser(user);
	}
	@GetMapping("/login")
	public ResponseEntity<ResponceStructur<UserDetails>> login(@RequestParam(value="uid",required = false) String uid,@RequestParam(value="uemail",required = false) String uemail,@RequestParam(value="password")String password){
		return service.login(uid,uemail,password);
	}
}
