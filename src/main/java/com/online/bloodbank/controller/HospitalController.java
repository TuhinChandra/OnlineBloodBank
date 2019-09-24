package com.online.bloodbank.controller;

import static com.online.bloodbank.constant.APIBasePathConstant.HOSPITAL_API_BASEPATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.model.Address;
import com.online.bloodbank.model.Contact;
import com.online.bloodbank.model.Hospital;
import com.online.bloodbank.service.HospitalService;

@RestController
@RequestMapping(value = HOSPITAL_API_BASEPATH)
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	// TODO: Use Post
	@PostMapping(value = "/registration/", produces = "application/json")
	public Hospital registerHospital(@RequestParam("registrationNo") final String registrationNo,
			@RequestParam("hospitalName") final String hospitalName, @RequestParam("city") final String city,
			@RequestParam("streetNo") final String streetNo, @RequestParam("pinCode") final long pinCode,
			@RequestParam("state") final String state, @RequestParam("contactName") final String contactName,
			@RequestParam("emailID") final String emailID, @RequestParam("contactNo") final long contactNo) {
		final Address address = new Address(city, streetNo, pinCode, state);
		final Contact contact = new Contact(contactName, emailID, contactNo);
		final Hospital hospital = new Hospital(registrationNo, hospitalName, address, contact);
		return hospitalService.registerHospital(hospital);
	}

	@GetMapping(value = "/{hospitalName}", produces = "application/json")
	public Hospital fetchHospitalFromName(@PathVariable("hospitalName") final String hospitalName) {
		return hospitalService.findByHospitalName(hospitalName);
	}
}
