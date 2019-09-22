package com.online.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.model.Blood;
import com.online.bloodbank.model.Patient;
import com.online.bloodbank.model.Users;
import com.online.bloodbank.repository.BloodRepository;
import com.online.bloodbank.repository.PatientRepository;
import com.online.bloodbank.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Users registerUser(final Users user) {
		final Users userSaved = userRepository.save(user);

		return userSaved;
	}

	public Users findByIDUsers(final String fullName, final String password) {
		final List<Users> userList = userRepository.findByFullNameAndPassword(fullName, password);
		if (userList.isEmpty()) {
			return null;
		} else {
			return userList.get(0);
		}
	}

	@Autowired
	private PatientRepository patientRepository;

	public Patient registerPatient(final Patient patient) {
		return patientRepository.save(patient);
	}

	public Patient findPatient(final String patientName) {
		final List<Patient> patientList = patientRepository.findByPatientName(patientName);
		if (patientList.isEmpty()) {
			return null;
		} else {
			return patientList.get(0);
		}

	}

	@Autowired
	private BloodRepository bloodRepository;

	public List<Blood> fetchBloodStock(final String bloodGroup) {
		final List<Blood> bloodList = bloodRepository.findBybloodGroup(bloodGroup);
		if (bloodList.isEmpty()) {
			return null;
		} else {
			return bloodList;
		}
	}
}
