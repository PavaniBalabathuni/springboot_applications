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
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.service.AddressService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService service;
	@PostMapping("/address")
	@ApiOperation(value = "Save Address",notes = "Api is used to save address id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully created"),
							@ApiResponse(code = 404,message = "Address Id not found")})
	public ResponseEntity<ResponseStructure<Address>> save(@RequestBody Address address){
		return service.saveAddress(address);
	}
	
	@DeleteMapping("/address")
	@ApiOperation(value = "Delete Address",notes = "Api is used to delete address details")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully deleted"),
							@ApiResponse(code = 404,message = "Address Id not found")})
	public ResponseEntity<ResponseStructure<Address>> delete(@RequestParam int id){
		return service.deleteAddress(id);
	}
	
	@PutMapping("/address")
	@ApiOperation(value = "Update Address",notes = "Api is used to update address details")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully updated"),
							@ApiResponse(code = 404,message = "Address Id not found")})
	public ResponseEntity<ResponseStructure<Address>> update(@RequestParam int id,@RequestBody Address address){
		return service.updateAddress(id, address);
		
	}
	
	@GetMapping("/address")
	@ApiOperation(value = "Get Address",notes = "Api is used to get address details")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully found"),
							@ApiResponse(code = 404,message = "Address Id not found")})
	public ResponseEntity<ResponseStructure<Address>> getById(@RequestParam int id){
		return service.getAddressById(id);
	}
	


}
