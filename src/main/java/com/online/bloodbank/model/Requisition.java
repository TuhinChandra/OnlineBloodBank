package com.online.bloodbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.online.bloodbank.enums.Status;

@Entity
public class Requisition {
	@Id
	@GeneratedValue
	private long id;
	private Status reqStatus;
	private int reqBloodUnit;
	public Patient patient;

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

	public Requisition(final Status reqStatus, final int reqBloodUnit, final Patient patient) {
		super();
		this.reqStatus = reqStatus;
		this.reqBloodUnit = reqBloodUnit;
		this.patient = patient;
	}

}
