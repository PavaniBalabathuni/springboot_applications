package com.ty.springboot_hospital_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.BranchDao;
import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	private BranchDao dao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hid,int aid) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		Branch daoBranch = dao.saveBranch(branch, hid, aid);
		if (daoBranch != null) {
			structure.setMessage("Saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(daoBranch);
		}
		return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);

	}
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id){
		Branch branch=dao.deleteBranch(id);
		ResponseStructure<Branch> structure=new ResponseStructure<>();
//		if(branch!=null) {
			structure.setMessage("Deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
//		}else {
//			throw new IdNotFoundException();
//		}
//		
				
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id,Branch branch){
		Branch branch2=dao.updateBranch(id, branch);
		ResponseStructure<Branch> structure=new ResponseStructure<>();
		if(branch2!=null) {
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch2);
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
//	public ResponseEntity<ResponseStructure<Branch>> getAllBBranch(int hid,Branch branch){
//		List<Branch> branch2=dao.getAllBranch(hid, branch);
//		ResponseStructure<Branch> structure=new ResponseStructure<>();
//		if(branch2!=null) {
//			structure.setMessage("successfully get");
//			structure.setStatus(HttpStatus.OK.value());
//			structure.setData(branch);
//			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
//			
//		}else {
//			throw new IdNotFoundException();
//		}
//	}
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id){
		Branch barnch2=dao.getBranchById(id);
		
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		if(barnch2!=null) {
		structure.setMessage("Successfully found");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(barnch2);
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchesByHospital(int hid) {
		List<Branch> branch2=dao.getAllBranchesByHospial(hid);
		ResponseStructure<List<Branch>> structure=new ResponseStructure<List<Branch>>();
		if(branch2!=null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch2);
			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure,HttpStatus.OK);
		}else {
		
		throw new IdNotFoundException();
		}
	}
	

}
