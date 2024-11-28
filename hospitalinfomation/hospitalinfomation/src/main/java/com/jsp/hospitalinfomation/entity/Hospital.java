package com.jsp.hospitalinfomation.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hid;
	private String hname;
	private String hmail;
	private long hphone;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hospital_id")
	private List<Branch> branches;
}
