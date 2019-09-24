package com.online.bloodbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdminUser {
	@Id
	@GeneratedValue
	private long id;
	private String fullName;
	private String password;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Contact contact;

	public long getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(final Contact contact) {
		this.contact = contact;
	}

	public AdminUser(final String fullName, final String password, final Contact contact) {
		super();
		this.fullName = fullName;
		this.password = password;
		this.contact = contact;
	}

	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}
}
