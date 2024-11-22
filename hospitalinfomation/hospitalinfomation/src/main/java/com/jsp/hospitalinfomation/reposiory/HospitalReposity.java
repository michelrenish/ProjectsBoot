package com.jsp.hospitalinfomation.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospitalinfomation.entity.Hospital;

public interface HospitalReposity extends JpaRepository<Hospital,Integer>{

}
