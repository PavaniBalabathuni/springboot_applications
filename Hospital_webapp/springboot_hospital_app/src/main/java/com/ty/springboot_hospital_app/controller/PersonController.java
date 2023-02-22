package com.ty.springboot_hospital_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.service.PersonService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@PostMapping("/person")
	@ApiOperation(value = "Save Person",notes = "Api is used to save Person")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully created"),
							@ApiResponse(code = 404,message = "Id not found for Person")})
	public ResponseEntity<ResponseStructure<Person>> save(@RequestBody Person person){
		return service.savePerson(person);
	}
	
	@DeleteMapping("/person")
	@ApiOperation(value = "Delete Person",notes = "Api is used to Delete Person")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully Deleted"),
							@ApiResponse(code = 404,message = "Id not found for Person")})
	public ResponseEntity<ResponseStructure<Person>> delete(@RequestParam int id){
		return service.deletePerson(id);
	}
	
	@PutMapping("/person")
	@ApiOperation(value = "Update Person",notes = "Api is used to Update Person")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully Updated"),
							@ApiResponse(code = 404,message = "Id not found for Person")})
	public ResponseEntity<ResponseStructure<Person>> update(@RequestParam int id,@RequestBody Person person){
		return service.updatePerson(id, person);
		
	}
	
	@GetMapping("/person")
	@ApiOperation(value = "Get Person",notes = "Api is used to get Person")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully Found"),
							@ApiResponse(code = 404,message = "Id not found for Person")})
	public ResponseEntity<ResponseStructure<Person>> getById(@RequestParam int id){
		return service.getPersonById(id);
	}
	

	

}
