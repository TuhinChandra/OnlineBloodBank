package com.online.bloodbank.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Contact {

	@Id
	@GeneratedValue
	private long id;
	private String contactName;
	private String emailID;
	private long contactNo;

	@OneToOne(mappedBy = "contact", fetch = FetchType.LAZY)
	private Hospital hospital;

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

}
