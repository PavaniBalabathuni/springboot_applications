package com.ty.springboot_hospital_app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.dao.HospitalDao;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.service.HospitalService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {
	
	@Autowired
	private HospitalService service;
	
	@Autowired
	private HospitalDao dao;
	
	@PostMapping("/hospital")
	@ApiOperation(value = "Save Hospital",notes = "Api is used to save hospital id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully created"),
							@ApiResponse(code = 404,message = "Id not found for hospital")})
	public ResponseEntity<ResponseStructure<Hospital>> save(@RequestBody Hospital hospital){
		return service.saveHospital(hospital);
	}
	
	@DeleteMapping("/hospital")
	@ApiOperation(value = "Delete Hospital",notes = "Api is used to delete hospital details")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully deleted"),
							@ApiResponse(code = 404,message = "Id not found for hospital")})
	public ResponseEntity<ResponseStructure<Hospital>> delete(@RequestParam int id){
		return service.deleteHospital(id);
	}
	
	@PutMapping("/hospital")
	@ApiOperation(value = "Update Hospital",notes = "Api is used to update hospital details")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully updated"),
							@ApiResponse(code = 404,message = "Id not found for hospital")})
	public ResponseEntity<ResponseStructure<Hospital>> update(@RequestParam int id,@RequestBody Hospital hospital){
		return service.updateHospital(id, hospital);
		
	}
	
	@GetMapping("/hospital")
	@ApiOperation(value = "Get Hospital",notes = "Api is used to get hospital")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully found"),
							@ApiResponse(code = 404,message = "Id not found for hospital")})
	public ResponseEntity<ResponseStructure<Hospital>> getById(@RequestParam int id){
		return service.getHospitalById(id);
	}
	

}
