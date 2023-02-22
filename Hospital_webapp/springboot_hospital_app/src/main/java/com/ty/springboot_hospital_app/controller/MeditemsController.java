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

import com.ty.springboot_hospital_app.dto.Meditems;
import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.service.MeditemsService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MeditemsController {
	
	@Autowired
	private MeditemsService service;
	
	@PostMapping("/meditems")
	@ApiOperation(value = "Save MedItems",notes = "Api is used to save MedItems")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully created"),
							@ApiResponse(code = 404,message = "Id not found for MedItems")})
	public ResponseEntity<ResponseStructure<Meditems>> save(@RequestBody Meditems meditems,@RequestParam int MedorderId){
		return service.saveMeditems(meditems,MedorderId);
	}
	
	@DeleteMapping("/meditems")
	@ApiOperation(value = "Delete MedItems",notes = "Api is used to Delete MedItems")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully Deleted"),
							@ApiResponse(code = 404,message = "Id not found for MedItems")})
	public ResponseEntity<ResponseStructure<Meditems>> delete(@RequestParam int id){
		return service.deleteMeditems(id);
	}
	
	@PutMapping("/meditems")
	@ApiOperation(value = "Update MedItems",notes = "Api is used to Update MedItems details")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully Updated"),
							@ApiResponse(code = 404,message = "Id not found for MedItems")})
	public ResponseEntity<ResponseStructure<Meditems>> update(@RequestParam int id,@RequestBody Meditems meditems){
		return service.updateMeditems(id, meditems);
		
	}
	
	@GetMapping("/meditems")
	@ApiOperation(value = "Get MedItems",notes = "Api is used to get MedItems details")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully Found"),
							@ApiResponse(code = 404,message = "Id not found for MedItems")})
	public ResponseEntity<ResponseStructure<Meditems>> getById(@RequestParam int id){
		return service.getMeditemsById(id);
	}


}
