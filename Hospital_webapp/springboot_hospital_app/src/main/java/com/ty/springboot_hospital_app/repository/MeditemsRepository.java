package com.ty.springboot_hospital_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_app.dto.Meditems;

public interface MeditemsRepository extends JpaRepository<Meditems, Integer>{

}
