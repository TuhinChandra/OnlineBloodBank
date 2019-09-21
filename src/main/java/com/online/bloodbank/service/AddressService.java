package com.online.bloodbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.model.Address;
import com.online.bloodbank.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	public Address register(final String city, final String streetNo, final long pinCode, final String state)
			throws Exception {
		final Address address = new Address(city, streetNo, pinCode, state);
		final Address add = addressRepository.save(address);
		return add;
	}

}
