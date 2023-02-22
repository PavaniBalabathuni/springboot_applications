package com.ty.springboot_hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Meditems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "meditem name cannot be null")
	private String name;
	//@NotBlank(message = "Cost cannot be blank")
	//change long to string
	private long cost;
	//change expirydate to noofPills
	private String expirydate;
	
	@ManyToOne
	private Medorder medorder;
	
	
	public Medorder getMedorder() {
		return medorder;
	}
	public void setMedorder(Medorder medorder) {
		this.medorder = medorder;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	@Override
	public String toString() {
		return "Meditems [id=" + id + ", name=" + name + ", cost=" + cost + ", expirydate=" + expirydate + "]";
	}
	

}
