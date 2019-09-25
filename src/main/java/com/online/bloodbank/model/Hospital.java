package com.online.bloodbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Hospital {
	@Id
	@GeneratedValue
	private long id;
	private String registrationNo;
	private String hospitalName;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Address address;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Contact contact;

	public Hospital() {

	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(final String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(final String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(final Contact contact) {
		this.contact = contact;
	}

	public Hospital(final String registrationNo, final String hospitalName, final Address address,
			final Contact contact) {
		super();
		this.registrationNo = registrationNo;
		this.hospitalName = hospitalName;
		this.address = address;
		this.contact = contact;
	}

}
