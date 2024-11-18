package com.jsp.springboot_pro.exeption;

public class IdNotFoundExeption extends RuntimeException {

	private String message="ID not Fonund";

	public IdNotFoundExeption(String message) {
		this.message = message;
	}
	public IdNotFoundExeption() {
		super();
	}
	@Override
	public String getMessage() {
		return this.message;
	}
	
	
}
