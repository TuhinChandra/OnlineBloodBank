package com.online.bloodbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.online.bloodbank.enums.BloodGroup;

@Entity

public class Blood {

	public Blood() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private long id;
	private BloodGroup bloodGroup;
	private String bloodType;
	private int bloodStock;
	private long hospitalId;

	public Blood(final BloodGroup bloodGroup, final String bloodType, final int bloodStock, final long hospitalId) {
		super();
		this.bloodGroup = bloodGroup;
		this.bloodType = bloodType;
		this.bloodStock = bloodStock;
		this.hospitalId = hospitalId;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(final BloodGroup bloodGroup) {
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
