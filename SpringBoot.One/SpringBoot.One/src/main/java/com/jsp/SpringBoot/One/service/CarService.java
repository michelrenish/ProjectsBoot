package com.jsp.SpringBoot.One.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.SpringBoot.One.dao.CarDao;
import com.jsp.SpringBoot.One.entity.Car;
import com.jsp.SpringBoot.One.utill.ResponceStructure;

@Service
public class CarService {
	@Autowired
	private CarDao cardao;
	
	public ResponseEntity<ResponceStructure<Car>> saveCar(Car car){
		ResponceStructure<Car> rs = new ResponceStructure<Car>();
		rs.setCode(HttpStatus.CREATED.value());
		rs.setData(car);
		rs.setMessage("Car details Saved");
		cardao.saveCar(car);
		return new ResponseEntity<ResponceStructure<Car>>(rs,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponceStructure<Car>> getCarById(int id) {
		ResponceStructure<Car> rs = new ResponceStructure<Car>();
		rs.setCode(HttpStatus.OK.value());
		rs.setData(cardao.getCarById(id));
		rs.setMessage("Car details of "+id);
		return new ResponseEntity<ResponceStructure<Car>>(rs,HttpStatus.OK);
	}
	public ResponseEntity<ResponceStructure<Car>> deleteCar(int id) {
		ResponceStructure<Car> rs = new ResponceStructure<Car>();
		rs.setCode(HttpStatus.OK.value());
		rs.setMessage("Car details of "+id+ " Deleted");
		cardao.deleteCar(id);
		return new ResponseEntity<ResponceStructure<Car>>(rs,HttpStatus.OK);
	}
}
