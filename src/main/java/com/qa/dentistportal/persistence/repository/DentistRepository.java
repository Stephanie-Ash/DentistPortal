package com.qa.dentistportal.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dentistportal.persistence.domain.Dentist;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {

}
