package com.online.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.model.Hospital;
import com.online.bloodbank.repository.HospitalRepository;

@Service
public class HospitalService {
	@Autowired
	private HospitalRepository hospitalRepository;

	public Hospital registerHospital(final Hospital hospital) {

		return hospitalRepository.save(hospital);

	}

	public Hospital findByhospitalName(final String hospitalName) {
		final List<Hospital> hospitalList = hospitalRepository.findByhospitalName(hospitalName);
		if (hospitalList.isEmpty()) {
			return null;
		} else {
			return hospitalList.get(0);
		}
	}

}
