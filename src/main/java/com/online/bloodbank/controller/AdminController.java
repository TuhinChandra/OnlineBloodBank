package com.online.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.model.Address;
import com.online.bloodbank.model.AdminUsers;
import com.online.bloodbank.model.Contact;
import com.online.bloodbank.model.Hospital;
import com.online.bloodbank.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping(value = "/admin/registration/{fullName}/{password}/{contactName}/{emailID}/{contactNo}", produces = "application/json")
	public AdminUsers registerAdmin(@PathVariable("fullName") final String fullName,
			@PathVariable("password") final String password, @PathVariable("contactName") final String contactName,
			@PathVariable("emailID") final String emailID, @PathVariable("contactNo") final long contactNo) {
		final Contact contact = new Contact(contactName, emailID, contactNo);
		final AdminUsers admin = new AdminUsers(fullName, password, contact);
		return adminService.registerAdmin(admin);
	}

	@RequestMapping(value = "/admin/login", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public AdminUsers loginEmployee(@RequestParam("fullName") final String fullName,
			@RequestParam("password") final String password) {

		final AdminUsers admin = adminService.findByIDAdminUsers(fullName, password);

		if (admin.getPassword().equalsIgnoreCase(password)) {
			return admin;
		} else {
			return null;
		}
	}

	@PostMapping(value = "/hospital/registration/", produces = "application/json")
	public Hospital registerHospital(@RequestParam("registrationNo") final String registrationNo,
			@RequestParam("hospitalName") final String hospitalName, @RequestParam("city") final String city,
			@RequestParam("streetNo") final String streetNo, @RequestParam("pinCode") final long pinCode,
			@RequestParam("state") final String state, @RequestParam("contactName") final String contactName,
			@RequestParam("emailID") final String emailID, @RequestParam("contactNo") final long contactNo) {
		final Address address = new Address(city, streetNo, pinCode, state);
		final Contact contact = new Contact(contactName, emailID, contactNo);
		final Hospital hospital = new Hospital(registrationNo, hospitalName, address, contact);
		return adminService.registerHospital(hospital);
	}

	@PostMapping(value = "/hospital/fetchFromName/", produces = "application/json")
	public Hospital fetchHospitalFromName(@RequestParam("hospitalName") final String hospitalName) {
		return adminService.findByhospitalName(hospitalName);
	}

}
