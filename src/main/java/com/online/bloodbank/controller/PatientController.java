package com.online.bloodbank.controller;

import static com.online.bloodbank.constant.APIBasePathConstant.PATIENT_API_BASEPATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.enums.BloodGroup;
import com.online.bloodbank.model.Patient;
import com.online.bloodbank.service.PatientService;

@RestController
@RequestMapping(value = PATIENT_API_BASEPATH)
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping(value = "/registration/", produces = "application/json")
	public Patient registerPatient(@RequestParam("patientName") final String patientName,
			@RequestParam("bloodGroup") final String bloodGroup,
			@RequestParam(value = "registrationNumber", required = false) final String registrationNumber) {
		final Patient patient = new Patient(patientName, BloodGroup.fromValue(bloodGroup), registrationNumber, null);
		return patientService.registerPatient(patient);
	}

	@GetMapping(value = "/{registrationNumber}", produces = "application/json")
	public Patient getPatientByRegistrationNo(@PathVariable("registrationNumber") final String registrationNumber) {
		return patientService.findPatient(registrationNumber);
	}

}
