package com.online.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.model.Patient;
import com.online.bloodbank.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping(value = "/user/patient/registration/", produces = "application/json")
	public Patient registerPatient(@RequestParam("patientName") final String patientName,
			@RequestParam("bloodGroup") final String bloodGroup) {
		final Patient patient = new Patient(patientName, bloodGroup);
		return patientService.registerPatient(patient);
	}

	@PostMapping(value = "/user/fetch/patient/", produces = "application/json")
	public Patient getPatientByName(@RequestParam("patientName") final String patientName) {
		return patientService.findPatient(patientName);
	}

}
