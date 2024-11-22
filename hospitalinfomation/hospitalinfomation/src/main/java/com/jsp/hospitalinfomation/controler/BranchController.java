package com.jsp.hospitalinfomation.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospitalinfomation.entity.Branch;
import com.jsp.hospitalinfomation.service.BranchService;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@RestController
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructur<Branch>> saveBranch(@RequestParam(value="id") int id,@RequestBody Branch branch){
		return branchService.saveBranch(id, branch);
	}
	@GetMapping("/getbranchid")
	public ResponseEntity<ResponseStructur<Branch>> getBranchById(@RequestParam(value="id") int id){
		return branchService.getBranchById(id);
	}
}
