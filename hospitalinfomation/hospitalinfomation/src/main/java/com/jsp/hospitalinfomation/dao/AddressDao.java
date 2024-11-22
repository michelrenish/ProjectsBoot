package com.jsp.hospitalinfomation.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospitalinfomation.entity.Address;
import com.jsp.hospitalinfomation.reposiory.AddressRepository;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepository addressRepository;
	
	public Address addressSave(Address address) {
		return addressRepository.save(address);
	}

	public Address getAddressId(int id) {
		Optional<Address> op = addressRepository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
}
