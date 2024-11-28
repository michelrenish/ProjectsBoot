package com.jsp.LoginPage.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.LoginPage.Util.ResponceStructur;


@RestControllerAdvice 
public class ApplicationExeptionHandler {
	
	@ExceptionHandler(UserGivenIdNotFound.class)
	public ResponseEntity<ResponceStructur<String>> IdNotFoundExeption(UserGivenIdNotFound ex){
		ResponceStructur<String> rs = new ResponceStructur<String>();
		rs.setData(ex.getMessage());
		rs.setMessage("User Given Id Not Found ");
		rs.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponceStructur<String>>(rs,HttpStatus.NOT_FOUND);
	}

}
