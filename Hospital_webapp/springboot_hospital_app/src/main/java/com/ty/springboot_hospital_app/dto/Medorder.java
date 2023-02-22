package com.ty.springboot_hospital_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Medorder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Doctorname canno be null")
	private String doctorname;
	//@NotBlank(message = "Bill cannot be blank")
	//change long to string
	private long totalbill;
	@ManyToOne
	private Encounter encounter;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public long getTotalbill() {
		return totalbill;
	}
	public void setTotalbill(long totalbill) {
		this.totalbill = totalbill;
	}
	
	public Encounter getEncounter() {
		return encounter;
	}
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	@Override
	public String toString() {
		return "Medorder [id=" + id + ", doctorname=" + doctorname + ", totalbill=" + totalbill + ", encounter="
				+ encounter + "]";
	}
	
	
	

}
