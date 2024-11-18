package com.jsp.springboot_pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.springboot_pro.Response.ResponceStructure;
import com.jsp.springboot_pro.dao.EmployeeDao;
import com.jsp.springboot_pro.entity.Employee;
import com.jsp.springboot_pro.exeption.IdNotFoundExeption;

@Service
public class EmployeeServie {
	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<ResponceStructure<Employee>> saveEmployee(Employee employee) {
		ResponceStructure<Employee> responceStructure = new ResponceStructure<Employee>();
		if (10 == String.valueOf(employee.getPhone()).length()) {
			responceStructure.setMessage("Employee Details are Saved");
			responceStructure.setStatuscode(HttpStatus.CREATED.value());
			responceStructure.setData(dao.SaveEmployee(employee));
			return new ResponseEntity<ResponceStructure<Employee>>(responceStructure, HttpStatus.CREATED);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponceStructure<Employee>> getEmpById(int id) {
		ResponceStructure<Employee> responceStructure = new ResponceStructure<Employee>();
		Employee e = dao.getEmpById(id);
		if (e != null) {
			responceStructure.setMessage("Employee Detail of ID: " + id);
			responceStructure.setStatuscode(HttpStatus.OK.value());
			responceStructure.setData(e);
			return new ResponseEntity<ResponceStructure<Employee>>(responceStructure, HttpStatus.OK);
		}
		throw new IdNotFoundExeption("Id not for given ID: " + id);

	}

	public ResponseEntity<ResponceStructure<Employee>> deleteById(int id) {
		ResponceStructure<Employee> responceStructure = new ResponceStructure<Employee>();
		Employee e = dao.getEmpById(id);
		if (e != null) {
			responceStructure.setMessage("Employee details Delete to ID: " + id);
			responceStructure.setStatuscode(HttpStatus.OK.value());
			dao.deleteById(id);
			return new ResponseEntity<ResponceStructure<Employee>>(responceStructure, HttpStatus.OK);
		}
		throw new IdNotFoundExeption("Id not for given ID: " + id);
	}

	public ResponseEntity<ResponceStructure<Employee>> updateEmp(int id, Employee updateEmp) {
		ResponceStructure<Employee> responceStructure = new ResponceStructure<Employee>();
		Employee e = dao.getEmpById(id);
		if (e != null) {
			responceStructure.setMessage("Employee details Updated to ID: " + id);
			responceStructure.setStatuscode(HttpStatus.OK.value());
			responceStructure.setData(updateEmp);
			dao.updateEmp(id, updateEmp);
			return new ResponseEntity<ResponceStructure<Employee>>(responceStructure, HttpStatus.OK);
		}
		throw new IdNotFoundExeption("Id not for given ID: " + id);
	}
}
