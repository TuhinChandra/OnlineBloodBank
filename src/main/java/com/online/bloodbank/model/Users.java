package com.online.bloodbank.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Users {
	@Id
	private String emailId;
	private String fullName;
	private String password;
	private long mobileNo;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(final String emailId, final String fullName, final String password, final long mobileNo) {
		super();
		this.emailId = emailId;
		this.fullName = fullName;
		this.password = password;
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPassword() {
		return password;
	}

	public long getMobileNo() {
		return mobileNo;
	}

}
