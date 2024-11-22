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
public class Prescription {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int did;
	private String dname;
	@OneToMany
	private List<Medicine> medicine;
}
