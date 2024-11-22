package com.jsp.SpringBoot.One.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.SpringBoot.One.entity.Car;

public interface CarRepository extends JpaRepository<Car,Integer> {

}
