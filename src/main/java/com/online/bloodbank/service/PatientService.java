package com.online.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.model.Patient;
import com.online.bloodbank.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;

	public Patient registerPatient(final Patient patient) {
		return patientRepository.save(patient);
	}

	public Patient findPatient(final String patientName) {
		final List<Patient> patientList = patientRepository.findByPatientName(patientName);
		if (patientList.isEmpty()) {
			return null;
		} else {
			return patientList.get(0);
		}
	}
}
