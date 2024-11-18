package com.jsp.springboot_pro.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot_pro.Response.ResponceStructure;

@RestControllerAdvice 
public class ApplicationExeptionHandler {
	
	@ExceptionHandler(IdNotFoundExeption.class)
	public ResponseEntity<ResponceStructure<String>> IdNotFoundExeption(IdNotFoundExeption ex){
		ResponceStructure<String> rs = new ResponceStructure<String>();
		rs.setData(ex.getMessage());
		rs.setMessage("Employee Id not Found ");
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponceStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
}
