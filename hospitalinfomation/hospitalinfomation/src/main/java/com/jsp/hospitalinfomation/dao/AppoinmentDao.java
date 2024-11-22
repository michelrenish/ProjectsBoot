package com.jsp.hospitalinfomation.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospitalinfomation.entity.Appoinment;
import com.jsp.hospitalinfomation.reposiory.AppoinmentRepository;

@Repository
public class AppoinmentDao {
	@Autowired
	private AppoinmentRepository aRepo;
	
	public Appoinment saveApoinment(Appoinment appoinment) {
		return aRepo.save(appoinment);
	}
	public Appoinment getApoinmentId(int id) {
		Optional<Appoinment> op = aRepo.findById(id);
		if(op.isPresent()){
			return op.get();
		}
		return null;
	}
}
