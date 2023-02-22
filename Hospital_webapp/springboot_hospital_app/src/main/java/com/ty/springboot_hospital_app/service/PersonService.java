package com.ty.springboot_hospital_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.PersonDao;
import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;
	
	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person){
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		Person daoPerson=dao.savePerson(person);
		if(daoPerson!=null) {
			structure.setMessage("Successfully saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(daoPerson);
		}
		return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id){
		Person person=dao.deletePerson(id);
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		if(person!=null) {
			structure.setMessage("Successfully deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.OK);
			
		}else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id){
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		Person person=dao.getPersonById(id);
		if(person!=null) {
		structure.setMessage("Successfully found");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.getPersonById(id));
		return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Person>> updatePerson(int id,Person person){
		Person daoPerson=dao.updatePerson(id,person);
		ResponseStructure<Person> structure=new ResponseStructure<>();
		if(daoPerson!=null) {
		structure.setMessage("Successfully updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.updatePerson(id,person));
		return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}


}
