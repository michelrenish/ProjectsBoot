package com.jsp.hospitalinfomation.utill;

import lombok.Data;

@Data
public class ResponseStructur<T> {
	private int code;
	private String message;
	private T data;
}
