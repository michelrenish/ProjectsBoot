package com.jsp.hospitalinfomation.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospitalinfomation.entity.Prescription;
import com.jsp.hospitalinfomation.service.PrescriptionService;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@RestController
public class PrescriptionController {
	@Autowired
	private PrescriptionService preService;
	
	@PostMapping("/savePrescription")
	public ResponseEntity<ResponseStructur<Prescription>> savePrescription(@RequestParam(value = "id") int id,@RequestBody Prescription prescription){
		return preService.savePrescription(id,prescription);
	}
	@GetMapping("/getPrescriptionId")
	public ResponseEntity<ResponseStructur<Prescription>> getPrescriptionId(@RequestParam(value = "id") int id){
		return preService.getPrescriptionId(id);
	}
}
