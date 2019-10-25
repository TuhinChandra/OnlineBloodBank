package com.online.bloodbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AdminUser {
	@Id
	@GeneratedValue
	private long id;
	private String fullName;
	private String emailId;
	private String password;
	private String role;
	private long contactNo;

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

	public AdminUser(final String fullName, final String emailId, final String password, final String role, final long contactNo) {
		super();
		this.fullName = fullName;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
		this.contactNo = contactNo;
	}

	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(final String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(final String role) {
		this.role = role;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(final long contactNo) {
		this.contactNo = contactNo;
	}
}
