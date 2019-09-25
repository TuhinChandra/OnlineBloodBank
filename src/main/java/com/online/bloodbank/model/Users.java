package com.online.bloodbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Users {
	@Id
	@GeneratedValue
	private long id;
	private String fullName;
	private String userName;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
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

	public Users(final String fullName, final String userName, final String password, final Contact contact) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.contact = contact;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

}
