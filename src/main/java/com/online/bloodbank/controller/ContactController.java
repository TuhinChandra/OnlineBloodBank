package com.online.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.model.Contact;
import com.online.bloodbank.service.ContactService;

@RestController
public class ContactController {
	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/createContact/{contactName}/{emailID}/{contactNo}", method = RequestMethod.GET, produces = "application/json")

	@ResponseBody
	public Contact createContact(@PathVariable("contactName") final String contactName,

			@PathVariable("emailID") final String emailID, @PathVariable("contactNo") final long contactNo)
			throws Exception {
		return contactService.register(contactName, emailID, contactNo);
	}

}
