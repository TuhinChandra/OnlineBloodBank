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

import com.online.bloodbank.model.Contact;
import com.online.bloodbank.model.Patient;
import com.online.bloodbank.model.Users;
import com.online.bloodbank.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "/user/registration/{fullName}/{password}/{contactName}/{emailID}/{contactNo}", produces = "application/json")
	public Users registerUser(@PathVariable("fullName") final String fullName,
			@PathVariable("password") final String password, @PathVariable("contactName") final String contactName,
			@PathVariable("emailID") final String emailID, @PathVariable("contactNo") final long contactNo) {
		final Contact contact = new Contact(contactName, emailID, contactNo);
		final Users user = new Users(fullName, password, contact);
		return userService.registerUser(user);
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Users loginEmployee(@RequestParam("fullName") final String fullName,
			@RequestParam("password") final String password) {

		final Users users = userService.findByIDUsers(fullName, password);

		if (users.getPassword().equalsIgnoreCase(password)) {
			return users;
		} else {
			return null;
		}
	}

	@PostMapping(value = "/user/patient/registration/", produces = "application/json")
	public Patient registerPatient(@RequestParam("patientName") final String patientName,
			@RequestParam("bloodGroup") final String bloodGroup) {
		final Patient patient = new Patient(patientName, bloodGroup);
		return userService.registerPatient(patient);
	}

	@PostMapping(value = "/user/fetch/patient/", produces = "application/json")
	public Patient getPatientByName(@RequestParam("patientName") final String patientName) {
		return userService.findPatient(patientName);
	}

}
