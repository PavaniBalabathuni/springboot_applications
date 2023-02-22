package com.ty.springboot_hospital_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.dto.Meditems;
import com.ty.springboot_hospital_app.dto.Medorder;
import com.ty.springboot_hospital_app.repository.MedorderRepository;

@Repository
public class MedorderDao {
	@Autowired
	private MedorderRepository medorderRepository;

	public Medorder saveMedorder(Medorder medorder) {

		return medorderRepository.save(medorder);
	}

	public Medorder deleteMedorder(int id) {
		Medorder medorder = medorderRepository.findById(id).get();
		medorderRepository.deleteById(id);
		
		return medorder;
	}

	public Medorder getMedorderById(int id) {
		return medorderRepository.findById(id).get();

	}

	public Medorder updateMedorder(Medorder medorder, int medorderId) {
		if (medorderRepository.findById(medorderId).isPresent()) {
			medorder.setId(medorderId);
			return medorderRepository.save(medorder);
		} else
			return null;

	}
}
