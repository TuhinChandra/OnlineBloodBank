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
	private long patient_id;

	public Requisition(final Status reqStatus, final int reqBloodUnit, final long patient_id) {
		super();
		this.reqStatus = reqStatus;
		this.reqBloodUnit = reqBloodUnit;
		this.patient_id = patient_id;
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

	public long getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(final long patient_id) {
		this.patient_id = patient_id;
	}

}
