package com.online.bloodbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue
	private long id;
	private String patientName;
	private String bloodGroup;
	@Column(nullable = true)
	public String registrationNumber;

	public Patient() {

	}

	public Patient(final String patientName, final String bloodGroup, final String registrationNumber,
			final Requisition requisition) {
		super();
		this.patientName = patientName;
		this.bloodGroup = bloodGroup;
		this.registrationNumber = registrationNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(final String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getPatientName() {
		return patientName;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setPatientName(final String patientName) {
		this.patientName = patientName;
	}

	public void setBloodGroup(final String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

}
