package com.online.bloodbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Blood {

	public Blood() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private long id;
	private String bloodGroup;
	private String bloodType;
	private int bloodStock;
	private long hospitalId;

	public Blood(final String bloodGroup, final String bloodType, final int bloodStock, final long hospitalId) {
		super();
		this.bloodGroup = bloodGroup;
		this.bloodType = bloodType;
		this.bloodStock = bloodStock;
		this.hospitalId = hospitalId;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(final String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(final String bloodType) {
		this.bloodType = bloodType;
	}

	public int getBloodStock() {
		return bloodStock;
	}

	public void setBloodStock(final int bloodStock) {
		this.bloodStock = bloodStock;
	}

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(final long hospitalId) {
		this.hospitalId = hospitalId;
	}

}
