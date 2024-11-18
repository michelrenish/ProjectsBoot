package com.jsp.springboot_student.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_student.entity.Student;
import com.jsp.springboot_student.repo.StudentRepo;

@Repository
public class StudentDao {
	@Autowired
	private StudentRepo repo;
	
	public void saveStudent(Student student) {
		repo.save(student);
	}
}
