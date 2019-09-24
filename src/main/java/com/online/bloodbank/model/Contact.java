package com.online.bloodbank.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Contact {

	@Id
	@GeneratedValue
	private long id;
	private String contactName;
	private String emailID;
	private long contactNo;

	@OneToOne(mappedBy = "contact", fetch = FetchType.EAGER)
	@JsonIgnore
	private Hospital hospital;

	@OneToOne(mappedBy = "contact", fetch = FetchType.EAGER)
	@JsonIgnore
	private Users user;

	@OneToOne(mappedBy = "contact", fetch = FetchType.EAGER)
	@JsonIgnore
	private AdminUser adminUsers;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(final String contactName) {
		this.contactName = contactName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(final String emailID) {
		this.emailID = emailID;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(final long contactNo) {
		this.contactNo = contactNo;
	}

	public Contact(final String contactName, final String emailID, final long contactNo) {
		super();
		this.contactName = contactName;
		this.emailID = emailID;
		this.contactNo = contactNo;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public AdminUser getAdminUsers() {
		return adminUsers;
	}

	public void setAdminUsers(final AdminUser adminUsers) {
		this.adminUsers = adminUsers;
	}

}
