package com.ty.springboot_hospital_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.repository.EncounterRepository;

@Repository
public class EncounterDao {
	@Autowired
	private EncounterRepository enRepository;
	
	public Encounter saveEncounter(Encounter encounter) {
		return enRepository.save(encounter);
	}
	public Encounter updateEncounter(Encounter encounter,int eid) {
		if(enRepository.findById(eid).isPresent()) {
			encounter.setId(eid);
			return enRepository.save(encounter);
		}else
			return null;
	}
	public Encounter getEncounterById(int eid) {
		
		return enRepository.findById(eid).get();
	}
	
	public Encounter deleteEncounter(int id) {
		Encounter encounter=enRepository.findById(id).get();
		enRepository.deleteById(id);
		return encounter;
	}

}
