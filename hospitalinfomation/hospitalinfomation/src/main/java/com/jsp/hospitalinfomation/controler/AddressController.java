package com.jsp.hospitalinfomation.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospitalinfomation.entity.Address;
import com.jsp.hospitalinfomation.service.AddressService;
import com.jsp.hospitalinfomation.utill.ResponseStructur;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructur<Address>> saveAddress(@RequestParam(value="id") int id,@RequestBody Address address){
		return addressService.saveAddress(id,address);
	}
	
	@GetMapping("/getAddressId")
	public ResponseEntity<ResponseStructur<Address>> getAddressId(@RequestParam(value = "id") int id){
		return addressService.getAddressId(id);
	}
}
