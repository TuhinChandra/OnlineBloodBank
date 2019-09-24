package com.online.bloodbank.service;

import java.util.List;

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

	public Contact getContactDetails(final long id) {
		final List<Contact> listContact = contactRepository.findById(id);
		if (listContact.isEmpty()) {
			return null;
		} else {
			return listContact.get(0);
		}

	}

	public Contact updateContact(final long id, final String emailID, final long contactNo) {
		final Contact contact = getContactDetails(id);
		contact.setEmailID(emailID);
		contact.setContactNo(contactNo);
		return contactRepository.save(contact);

	}
}
