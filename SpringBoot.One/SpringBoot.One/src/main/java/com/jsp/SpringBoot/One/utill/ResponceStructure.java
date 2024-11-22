package com.jsp.SpringBoot.One.utill;
import lombok.Data;

@Data
public class ResponceStructure<T> {
	private String message;
	private int code;
	private T data;
}
