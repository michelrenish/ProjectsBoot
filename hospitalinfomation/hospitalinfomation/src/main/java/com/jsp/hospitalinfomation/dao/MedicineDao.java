package com.jsp.hospitalinfomation.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospitalinfomation.entity.Medicine;
import com.jsp.hospitalinfomation.reposiory.MedicineRepository;

@Repository
public class MedicineDao {
	@Autowired
	private MedicineRepository medRepo;

	public Medicine saveMedicine(Medicine medicine) {
		return medRepo.save(medicine);
	}
	public Medicine getMedicineId (int id) {
		Optional<Medicine> op = medRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
}
