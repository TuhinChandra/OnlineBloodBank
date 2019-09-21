package com.online.bloodbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Hospital hospital;

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

	public Blood(final String bloodGroup, final String bloodType, final int bloodStock, final Hospital hospital) {
		super();
		this.bloodGroup = bloodGroup;
		this.bloodType = bloodType;
		this.bloodStock = bloodStock;
		this.hospital = hospital;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(final Hospital hospital) {
		this.hospital = hospital;
	}

}
