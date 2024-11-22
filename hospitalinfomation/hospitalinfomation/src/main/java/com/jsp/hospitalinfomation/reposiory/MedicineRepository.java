package com.jsp.hospitalinfomation.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospitalinfomation.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

}