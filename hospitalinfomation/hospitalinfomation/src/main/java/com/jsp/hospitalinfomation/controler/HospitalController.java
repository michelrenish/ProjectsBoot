package com.jsp.hospitalinfomation.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospitalinfomation.entity.Hospital;
import com.jsp.hospitalinfomation.service.HospitalService;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@RestController
public class HospitalController {
	
	@Autowired
	private HospitalService service;
	
	@PostMapping("/saveHospital")
	public ResponseEntity<ResponseStructur<Hospital>> saveHospital(@RequestBody Hospital hospital){
		return service.saveHospital(hospital);
	}
	@GetMapping("/getHospitalId")
	public ResponseEntity<ResponseStructur<Hospital>> getHospitalId(@RequestParam(value="id") int id){
		return service.getHospitalId(id);
	}
}
