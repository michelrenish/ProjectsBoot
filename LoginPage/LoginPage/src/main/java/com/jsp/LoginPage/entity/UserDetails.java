package com.jsp.LoginPage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserDetails {
	@Id
	private String uid;
	private String uname;
	private String uemail;
	private String password;
	private long phNo;	
}
