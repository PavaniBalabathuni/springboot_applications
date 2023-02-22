package com.ty.springboot_hospital_app.exception;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.util.ResponseStructure;


@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Id Not found ");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	//for Hospital get operation
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementExceptionHandler(NoSuchElementException ex){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("No such element found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	protected ResponseEntity<Object> handleMethodArgumentNotvalid(MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatus status,WebRequest request){
		List<ObjectError> error=ex.getAllErrors();
		Map<String, String> map=new LinkedHashMap<>();
		for(ObjectError er:error) {
			String feildName=((FieldError) er).getField();
			String message=((FieldError) er).getDefaultMessage();
			map.put(feildName, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintEntityViolationException(ConstraintViolationException constraintViolationException){
		Set<ConstraintViolation<?>> set=constraintViolationException.getConstraintViolations();
		List<String> list=new ArrayList<>();
		for(ConstraintViolation<?> constraintViolation:set) {
			String name=constraintViolation.getMessage();
			list.add(name);
			
		}
		return new ResponseEntity<Object>(list,HttpStatus.BAD_REQUEST);
	}

}
