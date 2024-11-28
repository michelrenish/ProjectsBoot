package com.jsp.hospitalinfomation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalinfomation.dao.HospitalDao;
import com.jsp.hospitalinfomation.entity.Hospital;
import com.jsp.hospitalinfomation.utill.ResponseStructur;
@Service
public class HospitalService {

	@Autowired
	private HospitalDao hosDao;
	
	public ResponseEntity<ResponseStructur<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructur<Hospital> rs=new ResponseStructur<Hospital>();
		rs.setMessage("Hospital Data Been Stored");
		rs.setData(hospital);
		rs.setCode(HttpStatus.CREATED.value());
		hosDao.saveHospital(hospital);
		return new ResponseEntity<ResponseStructur<Hospital>>(rs,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructur<Hospital>> getHospitalId(int id) {
		ResponseStructur<Hospital> rs=new ResponseStructur<Hospital>();
		rs.setMessage("Hospital Datails of ID: "+id);
		rs.setData(hosDao.getHospitalId(id));
		rs.setCode(201);
		return new ResponseEntity<ResponseStructur<Hospital>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructur<Hospital>> findByName(String name){
		ResponseStructur<Hospital> rs=new ResponseStructur<Hospital>();
		rs.setMessage("Hospital Datails of Name: "+name);
		rs.setData(hosDao.findByName(name));
		rs.setCode(201);
		return new ResponseEntity<ResponseStructur<Hospital>>(rs,HttpStatus.OK);
	}

}
