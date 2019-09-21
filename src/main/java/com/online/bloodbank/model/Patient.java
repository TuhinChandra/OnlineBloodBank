package com.online.bloodbank.model;

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

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(final String patientName) {
		this.patientName = patientName;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(final String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Patient(final String patientName, final String bloodGroup) {
		super();
		this.patientName = patientName;
		this.bloodGroup = bloodGroup;
	}

}
