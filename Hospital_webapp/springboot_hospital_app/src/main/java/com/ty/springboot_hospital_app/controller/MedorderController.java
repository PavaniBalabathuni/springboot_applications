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

import com.ty.springboot_hospital_app.dto.Medorder;
import com.ty.springboot_hospital_app.service.MedorderService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedorderController {
	
	@Autowired
	private MedorderService service;
	
	@PostMapping("/medorder")
	@ApiOperation(value = "Save MedOrder",notes = "Api is used to save Medorder")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully created"),
							@ApiResponse(code = 404,message = "Id not found for Medorder")})
	public ResponseEntity<ResponseStructure<Medorder>> saveMedorder(@RequestBody Medorder medorder,@RequestParam int encounterId) {
		return service.saveEncounter(medorder, encounterId);
	}
	
	@PutMapping("/medorder")
	@ApiOperation(value = "Update MedOrder",notes = "Api is used to update Medorder")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully updated"),
							@ApiResponse(code = 404,message = "Id not found for Medorder")})
	public ResponseEntity<ResponseStructure<Medorder>> update(@RequestBody Medorder medorder,@RequestParam int medorderId){
		return service.updateMedorder(medorder, medorderId);
	}
	
	@DeleteMapping("/medorder")
	@ApiOperation(value = "Delete MedOrder",notes = "Api is used to delete Medorder")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully Deleted"),
							@ApiResponse(code = 404,message = "Id not found for Medorder")})
	public ResponseEntity<ResponseStructure<Medorder>> delete(@RequestParam int id){
		return service.deleteMedorder(id);
		
	}
	@GetMapping("/medorder")
	@ApiOperation(value = "Get MedOrder",notes = "Api is used to get Medorder details")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully Found"),
							@ApiResponse(code = 404,message = "Id not found for Medorder")})
	public ResponseEntity<ResponseStructure<Medorder>> get(@RequestParam int id){
		return service.getMedorderById(id);
	}
	
	

}
