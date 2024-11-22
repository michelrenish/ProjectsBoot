package com.jsp.hospitalinfomation.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospitalinfomation.entity.Appoinment;
import com.jsp.hospitalinfomation.service.AppoinmentService;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@RestController
public class AppoinmentController {
	@Autowired
	private AppoinmentService aService;
	
	@PostMapping("/saveAppoinment")
	public ResponseEntity<ResponseStructur<Appoinment>> saveAppoinment(@RequestParam int id,@RequestBody Appoinment appoinment){
		return aService.saveAppoinment(id,appoinment);
	}
	@GetMapping("/getApoinmentId")
	public ResponseEntity<ResponseStructur<Appoinment>> getApoinmentId(@RequestParam int id){
		return aService.getApoinmentId(id);
	}
}
