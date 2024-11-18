package com.jsp.springboot_pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_pro.entity.Employee;

public interface EmployeRepo extends JpaRepository<Employee, Integer> {

}
