package com.ty.springboot_hospital_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.repository.HospitalRepository;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepository repository;

	public Hospital saveHospital(Hospital hospital) {
		return repository.save(hospital);
	}

	public Hospital deleteHospital(int id) {
		Hospital hospital = repository.findById(id).get();
		repository.deleteById(id);
		return hospital;
	}

	public Hospital updateHospital(int id, Hospital hospital) {

		if (repository.findById(id).isPresent()) {
			Hospital hospital2 = repository.findById(id).get();
			hospital.setId(id);
			repository.save(hospital);
			return hospital2;
		} else
			return null;

	}

	public Hospital getHospitalById(int id) {

		return repository.findById(id).get();

	}

	public List<Hospital> getAllHospital(Hospital hospital) {
		return repository.findAll();
	}

	public Hospital getByEmail(String email) {
		return repository.findByEmail(email);
	}

}
