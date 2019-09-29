package com.online.bloodbank.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Address {

	@Id
	@GeneratedValue
	private long id;
	private String city;
	private String streetNo;
	private long pinCode;
	private String state;
	@OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
	@JsonIgnoreProperties
	private Hospital hospital;

	public Address() {
		super();
	}

	public String getCity() {
		return city;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(final String streetNo) {
		this.streetNo = streetNo;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(final long pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public Address(final String city, final String streetNo, final long pinCode, final String state) {
		super();
		this.city = city;
		this.streetNo = streetNo;
		this.pinCode = pinCode;
		this.state = state;
	}

	public void setState(final String state) {
		this.state = state;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(final Hospital hospital) {
		this.hospital = hospital;
	}

}
