package com.jsp.hospitalinfomation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalinfomation.dao.BranchDao;
import com.jsp.hospitalinfomation.dao.HospitalDao;
import com.jsp.hospitalinfomation.entity.Branch;
import com.jsp.hospitalinfomation.entity.Hospital;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@Service
public class BranchService {
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private HospitalDao hosDao;

	public ResponseEntity<ResponseStructur<Branch>> saveBranch(int id, Branch branch) {
		Hospital hos = hosDao.getHospitalId(id);
		if (hos != null) {
			List<Branch> a1 = new ArrayList<Branch>();
			a1.add(branch);
			hos.setBranches(a1);
			branchDao.saveBranch(branch);
			ResponseStructur<Branch> rs = new ResponseStructur<Branch>();
			rs.setMessage("Branch details Are saved");
			rs.setCode(201);
			rs.setData(branch);
			return new ResponseEntity<ResponseStructur<Branch>>(rs, HttpStatus.CREATED);

		} else {
			hosDao.saveHospital(hos);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructur<Branch>> getBranchById(int id) {
		ResponseStructur<Branch> rs = new ResponseStructur<Branch>();
		rs.setMessage("Branch details of ID :" + id);
		rs.setCode(HttpStatus.OK.value());
		rs.setData(branchDao.getBranchById(id));
		return new ResponseEntity<ResponseStructur<Branch>>(rs, HttpStatus.OK);
	}
}
