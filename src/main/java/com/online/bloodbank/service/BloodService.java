package com.online.bloodbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.model.Blood;
import com.online.bloodbank.model.Hospital;
import com.online.bloodbank.repository.BloodRepository;

@Service
public class BloodService {

	@Autowired
	private BloodRepository bloodRepository;

	public Blood addNewBloodStock(final String bloodGroup, final String bloodType, final int bloodStock,
			final Hospital hospital) {

		final Blood blood = new Blood(bloodGroup, bloodType, bloodStock, hospital);
		final Blood newBloodStock = bloodRepository.save(blood);
		return newBloodStock;

	}
}
