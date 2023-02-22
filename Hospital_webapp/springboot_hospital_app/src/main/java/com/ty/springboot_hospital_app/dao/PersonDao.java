package com.ty.springboot_hospital_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository personRepository;

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public Person deletePerson(int id) {
		Person person = personRepository.findById(id).get();
		personRepository.deleteById(id);
		return person;

	}

	public Person updatePerson(int id, Person person) {

		if (personRepository.findById(id).isPresent()) {
			Person person2 = personRepository.findById(id).get();
			person.setId(id);
			personRepository.save(person);
			return person2;
		} else
			return null;

	}
	public Person getPersonById(int id) {
		if(personRepository.findById(id).isPresent()) {
			return personRepository.findById(id).get();
		}else
			return null;
	}
	
}
