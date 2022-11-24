package com.qa.dentistportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dentistportal.persistence.domain.Dentist;
import com.qa.dentistportal.service.DentistService;

@RestController
public class DentistController {
	
	private DentistService service;
	
	public DentistController(DentistService service) {
		this.service = service;
	}
	
	@PostMapping("/create/dentist")
	public Dentist addDentist(@RequestBody Dentist dentist) {
		return this.service.addDentist(dentist);
	}
	
	@GetMapping("/dentists")
	public List<Dentist> getAllDentists() {
		return this.service.getAllDentists();
	}
	
	@GetMapping("dentist/{id}")
	public Dentist getDentistById(@PathVariable Long id) {
		return this.service.getDentistById(id);
	}

}
