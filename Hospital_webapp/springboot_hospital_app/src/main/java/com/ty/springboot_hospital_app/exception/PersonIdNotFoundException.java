package com.ty.springboot_hospital_app.exception;

public class PersonIdNotFoundException extends RuntimeException{
private String mesaage="Id Not Found for Person";
	
	public String getMessage() {
		return mesaage;
	}

	public PersonIdNotFoundException(String mesaage) {
		super();
		this.mesaage = mesaage;
	}

	public PersonIdNotFoundException() {
		super();
		
	}
	

	
}
