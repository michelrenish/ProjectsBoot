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

import com.jsp.SpringBoot.One.entity.Car;
import com.jsp.SpringBoot.One.service.CarService;
import com.jsp.SpringBoot.One.utill.ResponceStructure;

@RestController
public class CarController {
	@Autowired
	private CarService service;
	@PostMapping("/saveCar")
	public ResponseEntity<ResponceStructure<Car>>saveCar(@RequestBody Car car) {
		return service.saveCar(car);
	}
	@GetMapping("/carid/{id}")
	public ResponseEntity<ResponceStructure<Car>> getCarId(@PathVariable int id) {
		return service.getCarById(id);
	}
	@DeleteMapping("deletecar/{id}")
	public ResponseEntity<ResponceStructure<Car>> deleteCar(@PathVariable int id) {
		return service.deleteCar(id);
	}
}
