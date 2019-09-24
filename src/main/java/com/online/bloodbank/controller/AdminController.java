package com.online.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.model.AdminUsers;
import com.online.bloodbank.model.Contact;
import com.online.bloodbank.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	// TODO: POST Mapping -- done
	@PostMapping(value = "/admin/registration", produces = "application/json")
	public AdminUsers registerAdmin(@RequestParam("fullName") final String fullName,
			@RequestParam("password") final String password, @RequestParam("contactName") final String contactName,
			@RequestParam("emailID") final String emailID, @RequestParam("contactNo") final long contactNo) {
		final Contact contact = new Contact(contactName, emailID, contactNo);
		final AdminUsers admin = new AdminUsers(fullName, password, contact);
		return adminService.registerAdmin(admin);
	}

	// TODO: Use @PostMapping
	@PostMapping(value = "/admin/login", produces = "application/json")
	@ResponseBody
	public AdminUsers loginAdmin(@RequestParam("fullName") final String fullName,
			@RequestParam("password") final String password) {

		return adminService.loginAdmin(fullName, password);
	}

}
