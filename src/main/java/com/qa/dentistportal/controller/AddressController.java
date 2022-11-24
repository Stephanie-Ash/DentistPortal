package com.qa.dentistportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dentistportal.persistence.domain.Address;
import com.qa.dentistportal.service.AddressService;

@RestController
public class AddressController {
	
	private AddressService service;
	
	public AddressController(AddressService service) {
		this.service = service;
	}
	
	@PostMapping("/create/address")
	public Address addAddress(@RequestBody Address address) {
		return this.service.addAddress(address);
	}
	
	@GetMapping("/addresses")
	public List<Address> getAllAddresses() {
		return this.service.getAllAddresses();
	}
	
	@GetMapping("address/{id}")
	public Address getAddressById(@PathVariable Long id) {
		return this.service.getAddressById(id);
	}

}
