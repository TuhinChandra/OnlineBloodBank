package com.online.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.enums.BloodGroup;
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
		if (blood.getBloodStock() > 0) {
			final List<Blood> listBlood = bloodRepository.findByBloodGroupAndBloodTypeAndHospitalId(
					blood.getBloodGroup(), blood.getBloodType(), blood.getHospitalId());
			if (listBlood.isEmpty()) {
				final Hospital hospital = hospitalService.findByHospitalId(blood.getHospitalId());
				if (null != hospital) {
					bloodRepository.save(blood);
				}
			}
		}
		return blood;

	}

	public Blood findByBloodGroupAndBloodType(final String bloodGroup, final String bloodType) {
		Blood blood = null;
		final List<Blood> listBlood = bloodRepository.findByBloodGroupAndBloodType(bloodGroup, bloodType);
		if (!listBlood.isEmpty()) {
			blood = listBlood.get(0);
		}
		return blood;
	}

	public Blood findByBloodGroupAndBloodTypeAndHospitalID(final BloodGroup bloodGroup, final String bloodType,
			final long hospitalId) {
		Blood blood = null;
		final List<Blood> listBlood = bloodRepository.findByBloodGroupAndBloodTypeAndHospitalId(bloodGroup, bloodType,
				hospitalId);
		if (!listBlood.isEmpty()) {
			blood = listBlood.get(0);
		}
		return blood;
	}

	public Blood updateBloodStockInHospital(final Blood blood, final int issuedStockQty, final long id) {

		Blood bloodToUpdate = null;
		if (issuedStockQty > 0) {
			bloodToUpdate = findByBloodGroupAndBloodTypeAndHospitalID(blood.getBloodGroup(), blood.getBloodType(), id);
			final int updatedStockQty = bloodToUpdate.getBloodStock() - issuedStockQty;
			bloodToUpdate.setBloodStock(updatedStockQty);
			bloodRepository.save(bloodToUpdate);
		}
		return bloodToUpdate;

	}

	public void deleteBlood(final long id) {

		bloodRepository.deleteById(id);
	}

}
