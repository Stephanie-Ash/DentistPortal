package com.qa.dentistportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.dentistportal.persistence.domain.Dentist;
import com.qa.dentistportal.persistence.repository.DentistRepository;

@Service
public class DentistService {
	
private DentistRepository repo;
	
	public DentistService(DentistRepository repo) {
		this.repo = repo;
	}
	
	public Dentist addDentist(Dentist dentist) {
		return this.repo.save(dentist);
	}
	
	public List<Dentist> getAllDentists() {
		return this.repo.findAll();
	}
	
	public Dentist getDentistById(Long id) {
		Optional<Dentist> dentist = this.repo.findById(id);
		return dentist.get();
	}
	
	public Dentist updateDentist(Long id, Dentist newDentist) {
		Dentist existingDentist = this.repo.findById(id).get();
		newDentist.setId(existingDentist.getId());
		
		return this.repo.save(newDentist);
	}
	
	public boolean deleteDentist(Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		
		return !exists;
	}
	
}
