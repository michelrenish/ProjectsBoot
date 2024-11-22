package com.jsp.hospitalinfomation.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospitalinfomation.entity.Appoinment;

public interface AppoinmentRepository extends JpaRepository<Appoinment, Integer> {

}
