package com.jsp.hospitalinfomation.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospitalinfomation.entity.Patients;

public interface PatientsReposiory extends JpaRepository<Patients, Integer>{

}
