package com.jsp.LoginPage.exeption;

public class UserGivenIdNotFound extends RuntimeException {
	private String message = "ID or Password not Fonund";

	public UserGivenIdNotFound(String message) {
		this.message = message;
	}

	public UserGivenIdNotFound() {
		super();
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
