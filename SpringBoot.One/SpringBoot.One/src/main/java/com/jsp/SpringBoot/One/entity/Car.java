package com.jsp.SpringBoot.One.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Car {

		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		private int carid;
		private String carname;
		private String carcolor;
		private double carprice;
		@OneToOne
		private Enginee enginee;
}
