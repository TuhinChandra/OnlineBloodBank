package com.online.bloodbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.online.bloodbank.enums.Status;

@Entity
public class Requisition {
	@Id
	@GeneratedValue
	private long id;
	private Status reqStatus;
	private int reqBloodUnit;
	@OneToOne(fetch = FetchType.LAZY)
	public Patient patient;
	@Column(nullable = true)
	public String registrationNumber;
	// public String message;

	public Status getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(final Status reqStatus) {
		this.reqStatus = reqStatus;
	}

	public int getReqBloodUnit() {
		return reqBloodUnit;
	}

	public void setReqBloodUnit(final int reqBloodUnit) {
		this.reqBloodUnit = reqBloodUnit;
	}

	public Requisition(final Status reqStatus, final int reqBloodUnit, final Patient patient,
			final String registrationNumber) {
		super();
		this.reqStatus = reqStatus;
		this.reqBloodUnit = reqBloodUnit;
		this.patient = patient;
		this.registrationNumber = registrationNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(final String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(final Patient patient) {
		this.patient = patient;
	}

}
