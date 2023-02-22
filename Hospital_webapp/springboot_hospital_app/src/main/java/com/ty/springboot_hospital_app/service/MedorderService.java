package com.ty.springboot_hospital_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.EncounterDao;
import com.ty.springboot_hospital_app.dao.MeditemsDao;
import com.ty.springboot_hospital_app.dao.MedorderDao;
import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.dto.Meditems;
import com.ty.springboot_hospital_app.dto.Medorder;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class MedorderService {
	@Autowired
	private MedorderDao medorderDao;

	@Autowired
	private EncounterDao enDao;

	public ResponseEntity<ResponseStructure<Medorder>> saveEncounter(Medorder medorder, int encounterId) {
		Encounter encounter = enDao.getEncounterById(encounterId);
		medorder.setEncounter(encounter);
		ResponseStructure<Medorder> structure = new ResponseStructure<>();
		structure.setMessage("saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(medorderDao.saveMedorder(medorder));
		return new ResponseEntity<ResponseStructure<Medorder>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Medorder>> deleteMedorder(int id) {
		Medorder medorder = medorderDao.deleteMedorder(id);
		ResponseStructure<Medorder> structure = new ResponseStructure<Medorder>();
		if (medorder != null) {
			structure.setMessage("Successfully deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Medorder>> getMedorderById(int id) {
		ResponseStructure<Medorder> structure = new ResponseStructure<Medorder>();
		Medorder medorder = medorderDao.getMedorderById(id);
		if (medorder != null) {
			structure.setMessage("Successfully found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Medorder>> updateMedorder(Medorder medorder, int medorderId) {
		Medorder daoMedorder = medorderDao.getMedorderById(medorderId);
		medorder.setEncounter(daoMedorder.getEncounter());

		ResponseStructure<Medorder> structure = new ResponseStructure<>();
		structure.setMessage("updated successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(medorderDao.updateMedorder(medorder, medorderId));
		return new ResponseEntity<ResponseStructure<Medorder>>(structure, HttpStatus.OK);
	}

}
