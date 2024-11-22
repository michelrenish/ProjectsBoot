package com.jsp.hospitalinfomation.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Patients {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int pid;
	private String pname;
	private int page;
	private String ptretment;
	@OneToMany
	private List<Appoinment> appoinment;
	
}
