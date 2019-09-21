package com.online.bloodbank.model;

public class BloodDonors {
	private String donorName;
	private Contact contact;
	private Address address;
	private Blood blood;
	private Patient patient;

	public BloodDonors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BloodDonors(final String donorName, final Contact contact, final Address address, final Blood blood,
			final Patient patient) {
		super();
		this.donorName = donorName;
		this.contact = contact;
		this.address = address;
		this.blood = blood;
		this.patient = patient;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(final String donorName) {
		this.donorName = donorName;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(final Contact contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	public Blood getBlood() {
		return blood;
	}

	public void setBlood(final Blood blood) {
		this.blood = blood;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(final Patient patient) {
		this.patient = patient;
	}

}
