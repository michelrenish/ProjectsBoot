package com.jsp.SpringBoot.One.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.SpringBoot.One.entity.Enginee;
import com.jsp.SpringBoot.One.service.EngineeService;
import com.jsp.SpringBoot.One.utill.ResponceStructure;

@RestController
public class EngnieeCantroller {
	@Autowired
	private EngineeService service;
	@PostMapping("/saveEnginee/{id}")
	public ResponseEntity<ResponceStructure<Enginee>>saveEnginee(@PathVariable int id,@RequestBody Enginee enginee) {
		return service.saveEnginee(id,enginee);
	}
	@GetMapping("/engineid")
	public ResponseEntity<ResponceStructure<Enginee>>getByEngineId(@RequestParam int id) {
		return service.getByEngineId(id);
	}
	@DeleteMapping("deleteengine")
	public ResponseEntity<ResponceStructure<Enginee>>deleteEngniee(@RequestParam int id){
		return service.deleteEngniee(id);
	}
}