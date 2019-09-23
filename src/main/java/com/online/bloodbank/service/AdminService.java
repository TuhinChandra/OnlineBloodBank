package com.online.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.model.AdminUsers;
import com.online.bloodbank.model.Blood;
import com.online.bloodbank.model.Hospital;
import com.online.bloodbank.repository.AdminRepository;
import com.online.bloodbank.repository.BloodRepository;
import com.online.bloodbank.repository.HospitalRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public AdminUsers registerAdmin(final AdminUsers admin) {
		final AdminUsers adminSaved = adminRepository.save(admin);

		return adminSaved;
	}

	public AdminUsers findByIDAdminUsers(final String fullName, final String password) {
		final List<AdminUsers> adminList = adminRepository.findByFullNameAndPassword(fullName, password);
		if (adminList.isEmpty()) {
			return null;
		} else {
			return adminList.get(0);
		}
	}

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

	@Autowired
	private BloodRepository bloodRepository;

	public Blood addBloodStockInHospital(final Blood blood) {

		return bloodRepository.save(blood);

	}

	public Blood updateBloodStockInHospital(final Blood blood, final int issuedStockQty, final String hospitalName) {

		Blood updatedBlood = null;
		final List<Blood> bloodList = bloodRepository.findByBloodGroupAndBloodType(blood.getBloodGroup(),
				blood.getBloodType());

		if (bloodList.isEmpty()) {
			return null;
		} else {

			for (int i = 0; i < bloodList.size(); i++) {
				if (bloodList.get(i).getHospital().getHospitalName().equals(hospitalName)) {
					updatedBlood = bloodList.get(i);
					final int updatedStock = updatedBlood.getBloodStock() - issuedStockQty;
					updatedBlood.setBloodStock(updatedStock);
					bloodRepository.save(updatedBlood);
					break;

				} else {
					continue;
				}
			}

		}
		return bloodRepository.save(updatedBlood);

	}

	public void deleteBlood(final long id) {

		bloodRepository.deleteById(id);
	}

}
