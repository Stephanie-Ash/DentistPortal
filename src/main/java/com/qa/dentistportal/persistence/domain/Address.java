package com.qa.dentistportal.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

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
	
	@OneToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private Patient patient;


	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", town="
				+ town + ", county=" + county + ", postcode=" + postcode + ", country=" + country + "]";
	}
	
}
