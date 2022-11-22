package com.qa.dentistportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.dentistportal.persistence.domain.Address;
import com.qa.dentistportal.persistence.repository.AddressRepository;

@Service
public class AddressService {
	
private AddressRepository repo;
	
	public AddressService(AddressRepository repo) {
		this.repo = repo;
	}
	
	public Address addAddress(Address address) {
		return this.repo.save(address);
	}
	
	public List<Address> getAllAddresses() {
		return this.repo.findAll();
	}
	
	public Address getAddressById(Long id) {
		Optional<Address> address = this.repo.findById(id);
		return address.get();
	}

}
