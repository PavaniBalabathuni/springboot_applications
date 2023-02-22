package com.ty.springboot_hospital_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.BranchDao;
import com.ty.springboot_hospital_app.dao.EncounterDao;
import com.ty.springboot_hospital_app.dao.PersonDao;
import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	private PersonDao personDao;
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private EncounterDao encounterDao;
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter,int personId, int branchId){
		Person person=personDao.getPersonById(personId);
		Branch branch=branchDao.getBranchById(branchId);
		encounter.setPerson(person);
		List<Branch> list=new ArrayList<Branch>();
		list.add(branch);
		encounter.setBranches(list);
		ResponseStructure<Encounter> structure=new ResponseStructure<>();
		structure.setMessage("saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(encounterDao.saveEncounter(encounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter,int eid,int branchId){
		Encounter daoEncounter=encounterDao.getEncounterById(eid);
		Branch branch=branchDao.getBranchById(branchId);
		List<Branch> list=daoEncounter.getBranches();
		list.add(branch);
		encounter.setBranches(list);
		encounter.setPerson(daoEncounter.getPerson());
		ResponseStructure<Encounter> structure=new ResponseStructure<>();
		structure.setMessage("updated successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(encounterDao.updateEncounter(encounter, eid));
		return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id){
		Encounter encounter=encounterDao.deleteEncounter(id);
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		if(encounter!=null) {
			structure.setMessage("Successfully deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.OK);
			
		}else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id){
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		Encounter encounter=encounterDao.getEncounterById(id);
		if(encounter!=null) {
		structure.setMessage("Successfully found");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(encounterDao.getEncounterById(id));
		return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}

}
