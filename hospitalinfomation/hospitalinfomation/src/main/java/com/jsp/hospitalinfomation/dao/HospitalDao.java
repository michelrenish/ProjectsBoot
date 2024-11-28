package com.jsp.hospitalinfomation.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospitalinfomation.entity.Hospital;
import com.jsp.hospitalinfomation.reposiory.HospitalReposity;

@Repository
public class HospitalDao {
	
	@Autowired
	private  HospitalReposity hosRepo;

	public Hospital saveHospital(Hospital hospital) {
		return hosRepo.save(hospital);
	}

	public Hospital getHospitalId(int id) {
		Optional<Hospital> op = hosRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	public Hospital findByName(String name) {
		return hosRepo.findByName(name);
	}
}
