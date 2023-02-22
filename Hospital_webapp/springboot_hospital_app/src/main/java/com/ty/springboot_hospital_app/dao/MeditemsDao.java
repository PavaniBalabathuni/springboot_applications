package com.ty.springboot_hospital_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Meditems;
import com.ty.springboot_hospital_app.repository.MeditemsRepository;

@Repository
public class MeditemsDao {
	@Autowired
	private MeditemsRepository medRepository;

	public Meditems saveMeditems(Meditems meditems) {
		return medRepository.save(meditems);
	}

	public Meditems deleteMedItems(int id) {
		Meditems meditems = medRepository.findById(id).get();
		if(meditems!=null) {
		medRepository.deleteById(id);
		return meditems;
		}
		else return null;

	}

	public Meditems updateMeditems(int id, Meditems meditems) {

		if (medRepository.findById(id).isPresent()) {
			Meditems meditems2 = medRepository.findById(id).get();
			meditems.setId(id);
			medRepository.save(meditems);
			return meditems2;
		} else
			return null;

	}

	public Meditems getMeditemsById(int id) {
		if (medRepository.findById(id).isPresent()) {
			return medRepository.findById(id).get();
		} else
			return null;
	}

}
