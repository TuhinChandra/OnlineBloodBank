package com.online.bloodbank.controller;

import static com.online.bloodbank.constant.APIBasePathConstant.USER_API_BASEPATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.model.Contact;
import com.online.bloodbank.model.Users;
import com.online.bloodbank.service.UserService;

@RestController
@RequestMapping(value = USER_API_BASEPATH)
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/registration", produces = "application/json")
	public Users registerUser(@RequestParam("fullName") final String fullName,
			@RequestParam("userName") final String userName, @RequestParam("password") final String password,
			@RequestParam("contactName") final String contactName, @RequestParam("emailID") final String emailID,
			@RequestParam("contactNo") final long contactNo) {
		final Contact contact = new Contact(contactName, emailID, contactNo);
		final Users user = new Users(fullName, userName, password, contact);
		return userService.registerUser(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Users loginEmployee(@RequestParam("userName") final String userName,
			@RequestParam("password") final String password) {

		return userService.loginUsers(userName, password);
	}

}
