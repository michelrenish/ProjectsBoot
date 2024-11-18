package com.jsp.springboot_pro.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_pro.Response.ResponceStructure;
import com.jsp.springboot_pro.entity.Employee;
import com.jsp.springboot_pro.service.EmployeeServie;

@RestController
public class EmployeeControler {
	@Autowired
	private EmployeeServie service;

	@GetMapping("/hello")
	public void print() {
		System.out.println("Hi everyone......");
	}

	@GetMapping("/hi")
	public String printhi() {
		return "Hi everyone......";
	}

	@PostMapping("/save")
	public ResponseEntity<ResponceStructure<Employee>> saveEmploye(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@GetMapping("/employee")
	public ResponseEntity<ResponceStructure<Employee>> getEmpById(@RequestParam int id) {
		return service.getEmpById(id);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ResponceStructure<Employee>> getId(@PathVariable int id) {
		return service.getEmpById(id);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponceStructure<Employee>> deleteByI(@RequestParam int id) {
		return service.deleteById(id);
	}

	@PutMapping("/empUpdate")
	public ResponseEntity<ResponceStructure<Employee>> updateEmp(@RequestParam int id, @RequestBody Employee Updateemp) {
		return service.updateEmp(id, Updateemp);
	}
}
