package com.jsp.springboot_student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_student.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}
