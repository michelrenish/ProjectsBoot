package com.jsp.hospitalinfomation.reposiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hospitalinfomation.entity.Branch;
import com.jsp.hospitalinfomation.entity.Hospital;

public interface BranchRepository extends JpaRepository<Branch,Integer>{

	@Query("SELECT h FROM Hospital h JOIN h.branches b WHERE b.bname = ?1")
	public List<Hospital> findByBranchName(String name);
}