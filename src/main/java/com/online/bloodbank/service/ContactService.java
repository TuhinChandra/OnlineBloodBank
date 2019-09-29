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
		Contact contact = null;
		final List<Contact> listContact = contactRepository.findById(id);
		if (!listContact.isEmpty()) {
			contact = listContact.get(0);
		}
		return contact;

	}

	public Contact updateContact(final long id, final String emailID, final long contactNo) {
		final Contact contact = getContactDetails(id);
		contact.setEmailID(emailID);
		contact.setContactNo(contactNo);
		return contactRepository.save(contact);

	}

	public Contact getContactFromEmail(final Contact contact) {
		Contact geContact = null;
		final List<Contact> listContact = contactRepository.findByEmailID(contact.getEmailID());
		if (!listContact.isEmpty()) {
			geContact = listContact.get(0);
		}
		return geContact;
	}
}
