package com.jsp.springboot_pro.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_pro.entity.Employee;
import com.jsp.springboot_pro.repository.EmployeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeRepo repo;

	public Employee SaveEmployee(Employee employee) {
		return repo.save(employee);
	}

	public Employee getEmpById(int id) {
//		return repo.findById(id).get();
		Optional<Employee> op = repo.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}
	public String deleteById(int id) {
		repo.deleteById(id);
		return "Employee Detail Deleted";
	}
	public Employee updateEmp(int id,Employee updateEmp) {
		Optional<Employee> op = repo.findById(id);
		if (op.isPresent()) {
			updateEmp.setId(id);
			return repo.save(updateEmp);
		} else {
			return null;
		}
	}
}
