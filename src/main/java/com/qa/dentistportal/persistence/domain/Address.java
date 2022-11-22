package com.qa.dentistportal.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "address_line1", nullable = false)
	private String addressLine1;
	
	@Column(name = "address_line2")
	private String addressLine2;
	
	@Column(nullable = false)
	private String town;
	
	@Column
	private String county;
	
	@Column
	private String postcode;
	
	@Column(nullable = false)
	private String country;
	
	@OneToOne(mappedBy = "address")
	private Patient patient;

}
