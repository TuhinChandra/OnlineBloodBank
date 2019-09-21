package com.online.bloodbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.model.Contact;
import com.online.bloodbank.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;

	public Contact register(final String contactName, final String emailID, final long contactNo) throws Exception {
		final Contact contact = new Contact(contactName, emailID, contactNo);
		final Contact con = contactRepository.save(contact);
		return con;
	}
}
