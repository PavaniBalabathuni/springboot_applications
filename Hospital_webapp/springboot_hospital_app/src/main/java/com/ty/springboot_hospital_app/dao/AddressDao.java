package com.ty.springboot_hospital_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.repository.AddressRepository;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepository addressRepository;

	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	public Address deleteAddress(int id) {
		Address address = addressRepository.findById(id).get();
		addressRepository.deleteById(id);
		return address;
	}

	public Address updateAddress(int id, Address address) {
		if (addressRepository.findById(id).isPresent()) {
			Address address2 = addressRepository.findById(id).get();
			address.setId(id);
			addressRepository.save(address);
			return address2;
		} else
			return null;

	}

	public Address getAddressById(int id) {

		return addressRepository.findById(id).get();

	}

}
