package com.jsp.hospitalinfomation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospitalinfomation.entity.Branch;
import com.jsp.hospitalinfomation.entity.Hospital;
import com.jsp.hospitalinfomation.reposiory.BranchRepository;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepository branchRepository;
	
	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public Branch getBranchById(int id) {
		Optional<Branch> op = branchRepository.findById(id);
		if(op.isPresent()) {
		return op.get();
		}
		return null;
	}
	
	public List<Hospital> findByBranchName(String name) {
		return branchRepository.findByBranchName(name);
	}
}
