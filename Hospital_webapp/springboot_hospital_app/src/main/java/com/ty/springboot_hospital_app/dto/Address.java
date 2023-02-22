package com.ty.springboot_hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Road number can not be blank")
	private String roadnum;
	@NotNull(message = "Streetname cannot be null")
	private String streetname;
	@NotNull(message = "cityname cannot be null")
	private String cityname;
	//@NotBlank(message = "Pincode cannot be blank")
	@NotNull(message = "pincodeee cannot be null")
	private long pincode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoadnum() {
		return roadnum;
	}
	public void setRoadnum(String roadnum) {
		this.roadnum = roadnum;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", roadnum=" + roadnum + ", streetname=" + streetname + ", cityname=" + cityname
				+ ", pincode=" + pincode + "]";
	}
	

}
