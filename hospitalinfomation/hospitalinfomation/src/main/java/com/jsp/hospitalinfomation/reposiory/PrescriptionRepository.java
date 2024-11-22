package com.jsp.hospitalinfomation.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospitalinfomation.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

}
