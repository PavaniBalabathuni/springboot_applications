package com.ty.springboot_hospital_app.service;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.AddressDao;
import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address){
		ResponseStructure<Address> structure=new ResponseStructure<Address>();
		Address daoAddress=dao.saveAddress(address);
		if(daoAddress!=null) {
			structure.setMessage("Successfully saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(daoAddress);
		}
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id){
		Address address=dao.deleteAddress(id);
		ResponseStructure<Address> structure=new ResponseStructure<Address>();
		if(address!=null) {
			structure.setMessage("Successfully deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
			
		}else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id){
		ResponseStructure<Address> structure=new ResponseStructure<Address>();
		Address address=dao.getAddressById(id);
		if(address!=null) {
		structure.setMessage("Successfully found");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.getAddressById(id));
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id,Address address){
		Address daoAddress=dao.updateAddress(id,address);
		ResponseStructure<Address> structure=new ResponseStructure<>();
		if(daoAddress!=null) {
		structure.setMessage("Successfully updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.updateAddress(id,address));
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}

}
