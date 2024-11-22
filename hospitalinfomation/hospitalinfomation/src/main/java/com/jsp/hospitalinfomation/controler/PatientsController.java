package com.jsp.hospitalinfomation.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospitalinfomation.entity.Patients;
import com.jsp.hospitalinfomation.service.PatientsService;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@RestController
public class PatientsController {
	@Autowired
	private PatientsService pService;
	
	@PostMapping("/savePatients")
	public ResponseEntity<ResponseStructur<Patients>> savePatients(@RequestParam(value = "id") int id,@RequestBody Patients patients){
		return pService.savePatients(id,patients);
	}
	@GetMapping("/getPatientsId")
	public ResponseEntity<ResponseStructur<Patients>> getPgetPatientsId(@RequestParam(value = "id") int id){
		return pService.getPatientsId(id);
	}
}
