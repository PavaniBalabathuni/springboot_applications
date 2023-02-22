package com.ty.springboot_hospital_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.repository.BranchRepository;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepository branchRepository;
	@Autowired
	private HospitalDao dao;
	@Autowired
	private AddressDao addressDao;

	public Branch saveBranch(Branch branch, int hid,int aid) {
		Hospital hospital = dao.getHospitalById(hid);
		Address address=addressDao.getAddressById(aid);
		branch.setHospital(hospital);
		branch.setAddress(address);
		return branchRepository.save(branch);
	}

	public Branch deleteBranch(int id) {
		Branch branch = branchRepository.findById(id).get();
		branchRepository.deleteById(id);
		return branch;
	}

	public Branch updateBranch(int id, Branch branch) {
		Branch branch2 = branchRepository.findById(id).get();
		if (branch2 != null) {

			Hospital hospital = branch2.getHospital();
			branch.setId(id);
			branch.setAddress(branch2.getAddress());
			branch.setHospital(hospital);

			return branchRepository.save(branch);
		} else {
			return null;
		}
	}

	public Branch getBranchById(int id) {
		if(branchRepository.findById(id).isPresent()) {
			return branchRepository.findById(id).get();
		}else
			return null;
		
	}

	public List<Branch> getAllBranchesByHospial(int hid) {
		Hospital hospital=dao.getHospitalById(hid);
		 if(hospital!=null) {
			 return branchRepository.getAllBrancheByHospital(hospital);
		 }else {
			 return null;
		 }
	}
}
