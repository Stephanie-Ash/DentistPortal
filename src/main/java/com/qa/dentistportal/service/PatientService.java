package com.qa.dentistportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.dentistportal.persistence.domain.Address;
import com.qa.dentistportal.persistence.domain.Patient;
import com.qa.dentistportal.persistence.repository.PatientRepository;

@Service
public class PatientService {
	
	private PatientRepository repo;
	
	public PatientService(PatientRepository repo) {
		this.repo = repo;
	}
	
	public Patient addPatient(Patient patient, Address address) {
		patient.setAddress(address);
		address.setPatient(patient);
		return this.repo.save(patient);
	}
	
	public List<Patient> getAllPatients() {
		return this.repo.findAll();
	}
	
	public Patient getPatientById(Long id) {
		Optional<Patient> patient = this.repo.findById(id);
		return patient.get();
	}

}
