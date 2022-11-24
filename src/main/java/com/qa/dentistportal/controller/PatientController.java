package com.qa.dentistportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dentistportal.persistence.domain.Patient;
import com.qa.dentistportal.service.PatientService;

@RestController
public class PatientController {
	
	private PatientService service;
	
	public PatientController(PatientService service) {
		this.service = service;
	}
	
	@PostMapping("/create/patient")
	public Patient addPatient(@RequestBody Patient patient) {
		return this.service.addPatient(patient);
	}
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		return this.service.getAllPatients();
	}
	
	@GetMapping("patient/{id}")
	public Patient getPatientById(@PathVariable Long id) {
		return this.service.getPatientById(id);
	}

}
