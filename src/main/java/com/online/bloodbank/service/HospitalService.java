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

	public Hospital findByHospitalName(final String hospitalName) {
		Hospital hospital = null;
		final List<Hospital> hospitalList = hospitalRepository.findByHospitalName(hospitalName);
		if (!hospitalList.isEmpty()) {
			hospital = hospitalList.get(0);
		}
		return hospital;
	}

	public Hospital findByHospitalId(final long id) {
		Hospital hospital = null;
		final List<Hospital> hospitalList = hospitalRepository.findById(id);
		if (!hospitalList.isEmpty()) {
			hospital = hospitalList.get(0);
		}
		return hospital;
	}

}
