package com.ty.springboot_hospital_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.service.EncounterService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {
	
	@Autowired
	private EncounterService service;
	@PostMapping("/encounter")
	@ApiOperation(value = "Save Encounter",notes = "Api is used to save Encounter  with person id and branch id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully created"),
							@ApiResponse(code = 404,message = "Id not found for Encounter")})
	public ResponseEntity<ResponseStructure<Encounter>> save(@RequestBody Encounter encounter,@RequestParam int personId,@RequestParam int branchId){
		return service.saveEncounter(encounter, personId, branchId);
	}
	@PutMapping("/encounter")
	@ApiOperation(value = "Update Encounter",notes = "Api is used to update Encounter  with encounter id and branch id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully updated"),
							@ApiResponse(code = 404,message = "Id not found for Encounter")})
	public ResponseEntity<ResponseStructure<Encounter>> update(@RequestBody Encounter encounter,@RequestParam int eid,@RequestParam int branchId){
		return service.updateEncounter(encounter,eid, branchId);
	}
	@DeleteMapping("/encounter")
	@ApiOperation(value = "Delete Encounter",notes = "Api is used to delete Encounter  with encounter id ")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully Deleted"),
							@ApiResponse(code = 404,message = "Id not found for Encounter")})

	public ResponseEntity<ResponseStructure<Encounter>> delete(@RequestParam int id){
		return service.deleteEncounter(id);
	}
	@GetMapping("/encounter")
	@ApiOperation(value = "Get Encounter",notes = "Api is used to Get Encounter details ")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully Found "),
							@ApiResponse(code = 404,message = "Id not found for Encounter")})

	public ResponseEntity<ResponseStructure<Encounter>> get(@RequestParam int id){
		return service.getEncounterById(id);
	}
	
	
	

}
