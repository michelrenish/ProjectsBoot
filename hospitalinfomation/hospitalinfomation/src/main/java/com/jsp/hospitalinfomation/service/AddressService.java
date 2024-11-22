package com.jsp.hospitalinfomation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalinfomation.dao.AddressDao;
import com.jsp.hospitalinfomation.dao.BranchDao;
import com.jsp.hospitalinfomation.entity.Address;
import com.jsp.hospitalinfomation.entity.Branch;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private BranchDao bDao;
	
	public ResponseEntity<ResponseStructur<Address>> saveAddress(int id,Address address){
		Branch br = bDao.getBranchById(id);
		Address add=null;
		if(br != null) {
			br.setAddress(address);
			add=addressDao.addressSave(address);
			ResponseStructur<Address> rs = new ResponseStructur<Address>();
			rs.setMessage("Address Details are stored");
			rs.setData(address);
			rs.setCode(201);
			addressDao.addressSave(address);
			return new ResponseEntity<ResponseStructur<Address>>(rs,HttpStatus.CREATED);
		}else {
			bDao.saveBranch(br);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
	}
	
	public ResponseEntity<ResponseStructur<Address>> getAddressId(int id){
		ResponseStructur<Address> rs = new ResponseStructur<Address>();
		rs.setMessage("Address Details of ID: "+id);
		rs.setData(addressDao.getAddressId(id));
		rs.setCode(200);
		return new ResponseEntity<ResponseStructur<Address>>(rs,HttpStatus.OK);
	}
}
