package com.online.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.online.bloodbank.model.Blood;
import com.online.bloodbank.model.Hospital;
import com.online.bloodbank.repository.BloodRepository;

@Service
public class BloodService {

	@Autowired
	private BloodRepository bloodRepository;

	@Autowired
	private HospitalService hospitalService;

	public Blood addBloodStockInHospital(final Blood blood) {

		final String hospitalName = blood.getHospital().getHospitalName();
		final Hospital hospital = hospitalService.findByhospitalName(hospitalName);
		if (hospital.getHospitalName().equals(hospitalName)) {
			blood.setHospital(hospital);
			return bloodRepository.save(blood);
		} else {
			return null;
		}

	}

	public Blood findByBloodGroupAndBloodType(final String bloodGroup, final String bloodType) {
		final List<Blood> listBlood = bloodRepository.findByBloodGroupAndBloodType(bloodGroup, bloodType);
		if (listBlood.isEmpty()) {
			return null;
		} else {
			return listBlood.get(0);
		}
	}

	public Blood updateBloodStockInHospital(final Blood blood, final int issuedStockQty) {

		final String hospitalName = blood.getHospital().getHospitalName();
		final Blood bloodToUpdate = findByBloodGroupAndBloodType(blood.getBloodGroup(), blood.getBloodType());
		final int updatedStockQty = bloodToUpdate.getBloodStock() - issuedStockQty;
		if (hospitalName.equalsIgnoreCase(bloodToUpdate.getHospital().getHospitalName())) {
			bloodToUpdate.setBloodStock(updatedStockQty);
			return bloodRepository.save(bloodToUpdate);
		} else {
			return null;
		}

	}

	public void deleteBlood(final long id) {

		bloodRepository.deleteById(id);
	}

}
