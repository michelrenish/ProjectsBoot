package com.jsp.springboot_student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_student.dao.StudentDao;
import com.jsp.springboot_student.entity.Student;

@RestController
public class StudentControler {
	
	@Autowired
	private StudentDao dao;
	
	@PostMapping("/save")
	public void saveStudent(@RequestBody Student student) {
		dao.saveStudent(student);
	}
}
