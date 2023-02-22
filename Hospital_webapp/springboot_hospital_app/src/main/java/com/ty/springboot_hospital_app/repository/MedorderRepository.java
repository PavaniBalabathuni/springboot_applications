package com.ty.springboot_hospital_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_app.dto.Medorder;

public interface MedorderRepository extends JpaRepository<Medorder, Integer>{

}
