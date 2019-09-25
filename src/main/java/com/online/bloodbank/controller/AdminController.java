package com.online.bloodbank.controller;

import static com.online.bloodbank.constant.APIBasePathConstant.ADMIN_API_BASEPATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.model.AdminUser;
import com.online.bloodbank.model.Contact;
import com.online.bloodbank.service.AdminService;

@RestController
@RequestMapping(value = ADMIN_API_BASEPATH)
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping(value = "/registration", produces = "application/json")
	public AdminUser registerAdmin(@RequestParam("fullName") final String fullName,
			@RequestParam("userName") final String userName, @RequestParam("password") final String password,
			@RequestParam("contactName") final String contactName, @RequestParam("emailID") final String emailID,
			@RequestParam("contactNo") final long contactNo) {

		final Contact contact = new Contact(contactName, emailID, contactNo);
		final AdminUser admin = new AdminUser(fullName, userName, password, contact);

		return adminService.registerAdmin(admin);
	}

	@PostMapping(value = "/login", produces = "application/json")
	@ResponseBody
	public AdminUser loginAdmin(@RequestParam("userName") final String userName,
			@RequestParam("password") final String password) {

		return adminService.loginAdmin(userName, password);
	}

}
