package com.online.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.model.Address;
import com.online.bloodbank.model.Contact;
import com.online.bloodbank.model.Hospital;
import com.online.bloodbank.service.HospitalService;

@RestController

public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	// TODO: Use Post
	@PostMapping(value = "/hospital/registration/", produces = "application/json")
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

	// TODO: @GetMapping
	@GetMapping(value = "/hospital/fetchFromName/", produces = "application/json")
	public Hospital fetchHospitalFromName(@RequestParam("hospitalName") final String hospitalName) {
		return hospitalService.findByhospitalName(hospitalName);
	}
}
