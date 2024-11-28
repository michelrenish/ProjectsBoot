package com.jsp.hospitalinfomation.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hospitalinfomation.entity.Hospital;

public interface HospitalReposity extends JpaRepository<Hospital,Integer>{
	
	@Query("Select h from Hospital h where h.hname=?1")
	public Hospital findByName(String name);

}
