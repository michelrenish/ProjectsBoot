package com.jsp.hospitalinfomation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalinfomation.dao.BranchDao;
import com.jsp.hospitalinfomation.dao.PatientsDao;
import com.jsp.hospitalinfomation.entity.Branch;
import com.jsp.hospitalinfomation.entity.Patients;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@Service
public class PatientsService {
	@Autowired
	private PatientsDao pDao;
	@Autowired
	private BranchDao bDao;

	public ResponseEntity<ResponseStructur<Patients>> savePatients(int id, Patients patients) {
		Branch brch = bDao.getBranchById(id);
		if (brch != null) {
			List<Patients> l1 = new ArrayList<Patients>();
			l1.add(patients);
			brch.setPatients(l1);
			pDao.savePatients(patients);
			ResponseStructur<Patients> rs = new ResponseStructur<Patients>();
			rs.setMessage("Patients Details are Saved");
			rs.setData(patients);
			rs.setCode(201);
			return new ResponseEntity<ResponseStructur<Patients>>(rs, HttpStatus.CREATED);
		} else {
			bDao.saveBranch(brch);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<ResponseStructur<Patients>> getPatientsId(int id) {
		ResponseStructur<Patients> rs = new ResponseStructur<Patients>();
		rs.setMessage("Details of patient Id: " + id);
		rs.setData(pDao.getPatientsId(id));
		rs.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructur<Patients>>(rs, HttpStatus.FOUND);
	}
}
