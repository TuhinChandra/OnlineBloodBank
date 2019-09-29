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
		Patient savePatient = null;
		if (null == findPatient(patient.getRegistrationNumber())) {
			savePatient = patientRepository.save(patient);
		}
		return savePatient;
	}

	public Patient findPatient(final String registrationNumber) {
		Patient patient = null;
		final List<Patient> patientList = patientRepository.findByRegistrationNumber(registrationNumber);
		if (!patientList.isEmpty()) {
			patient = patientList.get(0);
		}
		return patient;
	}

	public Patient FindById(final long id) {

		Patient patient = null;
		final List<Patient> patientList = patientRepository.findById(id);
		if (!patientList.isEmpty()) {
			patient = patientList.get(0);
		}
		return patient;
	}
}
