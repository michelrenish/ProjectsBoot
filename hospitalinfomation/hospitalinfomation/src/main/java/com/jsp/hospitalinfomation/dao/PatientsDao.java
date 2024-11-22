package com.jsp.hospitalinfomation.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospitalinfomation.entity.Patients;
import com.jsp.hospitalinfomation.reposiory.PatientsReposiory;

@Repository
public class PatientsDao {
	@Autowired
	private PatientsReposiory pRepo;
	
	public Patients savePatients(Patients patients) {
		return pRepo.save(patients);
	}
	public Patients getPatientsId(int id) {
		Optional<Patients> op = pRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
}
