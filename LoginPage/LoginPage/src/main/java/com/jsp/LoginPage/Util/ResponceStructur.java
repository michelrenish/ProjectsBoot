package com.jsp.LoginPage.Util;

import lombok.Data;

@Data
public class ResponceStructur<T> {
	private int code;
	private String message;
	private T data;

	
}
