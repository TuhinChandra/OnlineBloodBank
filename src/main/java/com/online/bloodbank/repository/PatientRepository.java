package com.online.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.online.bloodbank.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	List<Patient> findByRegistrationNumber(String registrationNumber);

	List<Patient> findById(long id);
}
