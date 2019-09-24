package com.online.bloodbank.controller;

import static com.online.bloodbank.constant.APIBasePathConstant.BLOOD_API_BASEPATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.model.Blood;
import com.online.bloodbank.model.Hospital;
import com.online.bloodbank.service.BloodService;

@RestController
@RequestMapping(value = BLOOD_API_BASEPATH)
public class BloodController {

	@Autowired
	private BloodService bloodService;

	// TODO: POST
	@PostMapping(value = "/stock/", produces = "application/json")
	public Blood addBloodStock(@RequestParam("bloodGroup") final String bloodGroup,
			@RequestParam("bloodType") final String bloodType, @RequestParam("bloodStock") final int bloodStock,
			@RequestParam("hospitalName") final String hospitalName) {

		final Hospital hospital = new Hospital(null, hospitalName, null, null);
		final Blood blood = new Blood(bloodGroup, bloodType, bloodStock, hospital);
		return bloodService.addBloodStockInHospital(blood);

	}

	@DeleteMapping("/{id}")
	public void deleteBloood(@PathVariable("id") final int id) {
		bloodService.deleteBlood(id);
	}

	@PutMapping(value = "/bloodStock/", produces = "application/json")
	public Blood updateBloodStock(@RequestParam("bloodGroup") final String bloodGroup,
			@RequestParam("bloodType") final String bloodType, @RequestParam("issuedStockQty") final int issuedStockQty,
			@RequestParam("hospitalName") final String hospitalName) {

		final Hospital hospital = new Hospital(null, hospitalName, null, null);
		final Blood blood = new Blood(bloodGroup, bloodType, 0, hospital);

		return bloodService.updateBloodStockInHospital(blood, issuedStockQty);

	}

}
