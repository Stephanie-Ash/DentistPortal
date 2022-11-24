package com.qa.dentistportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.qa.dentistportal.persistence.domain.Dentist;
import com.qa.dentistportal.service.AddressService;
import com.qa.dentistportal.service.DentistService;
import com.qa.dentistportal.service.PatientService;

@Controller
public class StaffAreaController {
	
	private PatientService patientService;
	private DentistService dentistService;
	private AddressService addressService;
	
	public StaffAreaController(PatientService patientService, DentistService dentistService, AddressService addressService) {
		this.patientService = patientService;
		this.dentistService = dentistService;
		this.addressService = addressService;
	}
	
	@GetMapping("/info")
	public String infoPage(Model model) {
		model.addAttribute("dentists", dentistService.getAllDentists());
		model.addAttribute("addresses", addressService.getAllAddresses());
		model.addAttribute("patients", patientService.getAllPatients());
		
		return "info";
	}
	
	@GetMapping("/addDentist")
	public String addDentistPage(Model model) {
		model.addAttribute("newDentist", new Dentist());
		
		return "addDentist";
	}
	
	@PostMapping("/addDentist")
	public String addDentist(Model model, @ModelAttribute Dentist newDentist) {
		dentistService.addDentist(newDentist);
		return "redirect:/info";
	}

}
