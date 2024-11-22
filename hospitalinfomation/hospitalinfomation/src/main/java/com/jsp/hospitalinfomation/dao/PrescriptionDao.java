package com.jsp.hospitalinfomation.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospitalinfomation.entity.Prescription;
import com.jsp.hospitalinfomation.reposiory.PrescriptionRepository;

@Repository
public class PrescriptionDao {
	@Autowired
	private PrescriptionRepository preRepo;
	
	public Prescription savePrescription(Prescription prescription ) {
		return preRepo.save(prescription);
	}
	public Prescription getPrescriptionId(int id) {
		Optional<Prescription> op = preRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	
}
