package com.ty.springboot_hospital_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.MeditemsDao;
import com.ty.springboot_hospital_app.dao.MedorderDao;
import com.ty.springboot_hospital_app.dto.Meditems;
import com.ty.springboot_hospital_app.dto.Medorder;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class MeditemsService {
	@Autowired
	private MeditemsDao dao;
	@Autowired
	private MedorderDao medorderDao;

	public ResponseEntity<ResponseStructure<Meditems>> saveMeditems(Meditems meditems,int medorderId) {
		ResponseStructure<Meditems> structure = new ResponseStructure<Meditems>();
		Medorder medorder=medorderDao.getMedorderById(medorderId);
		meditems.setMedorder(medorder);
		Meditems daoMeditems = dao.saveMeditems(meditems);
		if (daoMeditems != null) {
			structure.setMessage("Successfully saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(daoMeditems);
		}
		return new ResponseEntity<ResponseStructure<Meditems>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Meditems>> deleteMeditems(int id) {
		Meditems meditems = dao.deleteMedItems(id);
		ResponseStructure<Meditems> structure = new ResponseStructure<Meditems>();
		if (meditems != null) {
			structure.setMessage("Successfully deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Meditems>> getMeditemsById(int id) {
		ResponseStructure<Meditems> structure = new ResponseStructure<Meditems>();
		Meditems meditems = dao.getMeditemsById(id);
		if (meditems != null) {
			structure.setMessage("Successfully found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Meditems>> updateMeditems(int id,Meditems meditems){
		Meditems daoMeditems=dao.updateMeditems(id,meditems);
		ResponseStructure<Meditems> structure=new ResponseStructure<>();
		if(daoMeditems!=null) {
		structure.setMessage("Successfully updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(daoMeditems);
		return new ResponseEntity<ResponseStructure<Meditems>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}

}
