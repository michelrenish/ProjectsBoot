package com.jsp.SpringBoot.One.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.SpringBoot.One.entity.Car;
import com.jsp.SpringBoot.One.entity.Enginee;

public interface EngineeRepsitory extends JpaRepository<Enginee,Integer> {

}
