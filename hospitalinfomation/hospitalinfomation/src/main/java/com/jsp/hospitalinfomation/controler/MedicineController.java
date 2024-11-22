package com.jsp.hospitalinfomation.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospitalinfomation.entity.Medicine;
import com.jsp.hospitalinfomation.service.MedicineService;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@RestController
public class MedicineController {
	@Autowired
	private MedicineService medService;
	
	@PostMapping("/saveMedicine")
	public ResponseEntity<ResponseStructur<Medicine>> saveMedicine(@RequestParam(value = "id") int id,@RequestBody Medicine medicine){
		return medService.saveMedicine(id,medicine);
	}
	@GetMapping("getMedicineId")
	public ResponseEntity<ResponseStructur<Medicine>> getMedicineId(int id){
		return medService.getMedicineId(id);
	}
}
