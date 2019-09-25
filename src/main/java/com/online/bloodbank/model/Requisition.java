package com.online.bloodbank.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.online.bloodbank.enums.Status;

@Entity

public class Requisition {
	@Id
	@GeneratedValue
	private long id;
	private Status reqStatus;
	private int reqBloodUnit;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	public Patient patient;

	public Requisition(final Status reqStatus, final int reqBloodUnit, final Patient patient) {
		super();
		this.reqStatus = reqStatus;
		this.reqBloodUnit = reqBloodUnit;
		this.patient = patient;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(final Patient patient) {
		this.patient = patient;
	}

	public Status getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(final Status reqStatus) {
		this.reqStatus = reqStatus;
	}

	public Requisition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReqBloodUnit() {
		return reqBloodUnit;
	}

	public void setReqBloodUnit(final int reqBloodUnit) {
		this.reqBloodUnit = reqBloodUnit;
	}

}
