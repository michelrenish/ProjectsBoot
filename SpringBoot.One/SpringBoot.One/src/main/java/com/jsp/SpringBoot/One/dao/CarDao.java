package com.jsp.SpringBoot.One.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.SpringBoot.One.entity.Car;
import com.jsp.SpringBoot.One.reposiory.CarRepository;

@Repository
public class CarDao {
	@Autowired
	private CarRepository carrepo;

	public Car saveCar(Car car) {
		return carrepo.save(car);
	}

	public Car getCarById(int id) {
		Optional<Car> op = carrepo.findById(id);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	public boolean deleteCar(int id) {
		if (getCarById(id) != null) {
			carrepo.delete(getCarById(id));
			return true;
		}
		return false;
	}
}
