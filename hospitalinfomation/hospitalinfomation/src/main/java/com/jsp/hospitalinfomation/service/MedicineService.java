package com.jsp.hospitalinfomation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.hospitalinfomation.dao.MedicineDao;
import com.jsp.hospitalinfomation.dao.PrescriptionDao;
import com.jsp.hospitalinfomation.entity.Medicine;
import com.jsp.hospitalinfomation.entity.Prescription;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@Service
public class MedicineService {
	@Autowired
	private MedicineDao medDao;
	@Autowired
	private PrescriptionDao pDao;

	public ResponseEntity<ResponseStructur<Medicine>> saveMedicine(int id,Medicine medicine) {
		Prescription pre = pDao.getPrescriptionId(id);
		if(pre != null) {
			List<Medicine> list = new ArrayList<Medicine>();
			list.add(medicine);
			pre.setMedicine(list);
			medDao.saveMedicine(medicine);
			ResponseStructur<Medicine> rs = new ResponseStructur<Medicine>();
			rs.setMessage("Medicine details are Saved");
			rs.setData(medicine);
			rs.setCode(201);
			return new ResponseEntity<ResponseStructur<Medicine>>(rs, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<ResponseStructur<Medicine>> getMedicineId(int id) {
		ResponseStructur<Medicine> rs = new ResponseStructur<Medicine>();
		rs.setMessage("Medicine details of Id: "+id);
		rs.setData(medDao.getMedicineId(id));
		rs.setCode(200);
		return new ResponseEntity<ResponseStructur<Medicine>>(rs, HttpStatus.FOUND);
	}
	
}
