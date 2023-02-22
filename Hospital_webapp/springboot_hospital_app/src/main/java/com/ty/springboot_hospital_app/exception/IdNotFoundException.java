package com.ty.springboot_hospital_app.exception;

import org.springframework.beans.factory.annotation.Autowired;

public class IdNotFoundException extends RuntimeException{
	@Autowired
	private String mesaage="Id Not Found";
	
	public String getMessage() {
		return mesaage;
	}

	public IdNotFoundException(String mesaage) {
		super();
		this.mesaage = mesaage;
	}

	public IdNotFoundException() {
		super();
		
	}
	
	
	

}
