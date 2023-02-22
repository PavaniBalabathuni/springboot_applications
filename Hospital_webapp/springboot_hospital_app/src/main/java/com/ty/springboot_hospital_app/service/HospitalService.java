package com.ty.springboot_hospital_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.springboot_hospital_app.dao.HospitalDao;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.repository.HospitalRepository;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalDao dao;
	
	@Autowired
	private HospitalRepository repository;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital){
		ResponseStructure<Hospital> structure=new ResponseStructure<>();
		Hospital dbHospital=dao.saveHospital(hospital);
		if(dbHospital!=null) {
			structure.setMessage("Successfully saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dbHospital);
		}
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id){
		Hospital hospital=dao.deleteHospital(id);
		ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
		if(hospital!=null) {
			structure.setMessage("Successfully deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
			
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id){
		ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
		Hospital hospital=dao.getHospitalById(id);
		if(hospital!=null) {
		structure.setMessage("Successfully found");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.getHospitalById(id));
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id,Hospital hospital){
		Hospital daoHospital=dao.updateHospital(id,hospital);
		ResponseStructure<Hospital> structure=new ResponseStructure<>();
		if(daoHospital!=null) {
		structure.setMessage("Successfully updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.updateHospital(id,hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}

}
