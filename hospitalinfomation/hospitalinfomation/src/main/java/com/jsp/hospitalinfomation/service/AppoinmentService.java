package com.jsp.hospitalinfomation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalinfomation.dao.AppoinmentDao;
import com.jsp.hospitalinfomation.dao.PatientsDao;
import com.jsp.hospitalinfomation.entity.Appoinment;
import com.jsp.hospitalinfomation.entity.Patients;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@Service
public class AppoinmentService {
	@Autowired
	private AppoinmentDao aDao;
	@Autowired
	private PatientsDao pDao;

	public ResponseEntity<ResponseStructur<Appoinment>> saveAppoinment(int id, Appoinment appoinment) {
		Patients p = pDao.getPatientsId(id);
		if (p != null) {
			List<Appoinment> l1 = new ArrayList<Appoinment>();
			l1.add(appoinment);
			p.setAppoinment(l1);
			aDao.saveApoinment(appoinment);
			ResponseStructur<Appoinment> rs = new ResponseStructur<Appoinment>();
			rs.setMessage("Appoinment Details are saved");
			rs.setCode(201);
			rs.setData(appoinment);
			return new ResponseEntity<ResponseStructur<Appoinment>>(rs, HttpStatus.CREATED);
		} else {
			pDao.savePatients(p);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity<ResponseStructur<Appoinment>> getApoinmentId(int id) {
		ResponseStructur<Appoinment> rs = new ResponseStructur<Appoinment>();
		rs.setMessage("Appoinment Detail Of ID: " + id);
		rs.setCode(200);
		rs.setData(aDao.getApoinmentId(id));
		return new ResponseEntity<ResponseStructur<Appoinment>>(rs, HttpStatus.FOUND);
	}
}
