package com.ty.springboot_hospital_app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.Hospital;

public interface BranchRepository extends JpaRepository<Branch, Integer>{
	
	@Query("select br from Branch br where br.hospital=?1")
	public List<Branch> getAllBrancheByHospital(Hospital hospital);

}
