package com.ty.springboot_hospital_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.service.BranchService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {
	
	@Autowired
	private BranchService service;
	
	@PostMapping("/branch")
	@ApiOperation(value = "Save Branch",notes = "Api is used to save branch with hospital id and address id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully created"),
							@ApiResponse(code = 404,message = "Id not found for given Branch")})
	public ResponseEntity<ResponseStructure<Branch>> save(@RequestBody Branch branch,@RequestParam int hid,@RequestParam int aid) {
		return service.saveBranch(branch, hid,aid);
	}
	
	@DeleteMapping("/branch")
	@ApiOperation(value = "Delete Branch",notes = "Api is used to delete branch details")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully deleted"),
							@ApiResponse(code = 404,message = "Id not found for given Branch")})
	public ResponseEntity<ResponseStructure<Branch>> delete(@RequestParam int id){
		return service.deleteBranch(id);
	}
	
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Update Branch",notes = "Api is used to update branch with branch id ")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully updated"),
							@ApiResponse(code = 404,message = "Id not found for given Branch")})
	public ResponseEntity<ResponseStructure<Branch>> update(@PathVariable int id,@RequestBody Branch branch){
		return service.updateBranch(id, branch);
	}
	@GetMapping("/getall/{hid}")
	@ApiOperation(value = "Get All Branch Details",notes = "Api is used to Getall branch details with hospital id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully found"),
							@ApiResponse(code = 404,message = "Id not found for given Branch")})
	public ResponseEntity<ResponseStructure<List<Branch>>> getAll(@PathVariable int hid){
		return service.getAllBranchesByHospital(hid);
	}
	@GetMapping("branch")
	@ApiOperation(value = "Get Branch details",notes = "Api is used to get branch details with branch id ")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully found"),
							@ApiResponse(code = 404,message = "Id not found for given Branch")})
	public ResponseEntity<ResponseStructure<Branch>> getById(@RequestParam int id){
		return service.getBranchById(id);
	}

}
