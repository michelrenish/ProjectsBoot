package com.jsp.LoginPage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.LoginPage.entity.UserDetails;

public interface UserRepo extends JpaRepository<UserDetails,String>{
	
	@Query("select u from UserDetails u where u.uid=?1 and u.password=?2")
	public UserDetails loginById(String uid , String password);
	
	@Query("select u from UserDetails u where u.uemail=?1 and u.password=?2")
	public UserDetails loginByMail(String uemail , String password);
}
