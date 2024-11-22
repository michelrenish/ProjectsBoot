package com.jsp.hospitalinfomation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalinfomation.dao.AppoinmentDao;
import com.jsp.hospitalinfomation.dao.PrescriptionDao;
import com.jsp.hospitalinfomation.entity.Appoinment;
import com.jsp.hospitalinfomation.entity.Prescription;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@Service
public class PrescriptionService {
	@Autowired
	private PrescriptionDao preDao;
	@Autowired
	private AppoinmentDao aDao;
	
	public ResponseEntity<ResponseStructur<Prescription>> savePrescription(int id,Prescription prescription){
		Appoinment app = aDao.getApoinmentId(id);
		if(app!=null) {
			app.setDescription(prescription);
			ResponseStructur<Prescription> rs =new ResponseStructur<Prescription>();
			preDao.savePrescription(prescription);
			rs.setMessage("Prescription details are saved");
			rs.setData(prescription);
			rs.setCode(201);
			return new ResponseEntity<ResponseStructur<Prescription>>(rs,HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	public ResponseEntity<ResponseStructur<Prescription>> getPrescriptionId(int id){
		ResponseStructur<Prescription> rs =new ResponseStructur<Prescription>();
		rs.setMessage("Prescription details of ID: "+id);
		rs.setData(preDao.getPrescriptionId(id));
		rs.setCode(200);
		return new ResponseEntity<ResponseStructur<Prescription>>(rs,HttpStatus.FOUND);
	}
}
