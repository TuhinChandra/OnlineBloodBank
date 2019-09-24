package com.online.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.model.Blood;
import com.online.bloodbank.model.Hospital;
import com.online.bloodbank.service.BloodService;

@RestController
public class BloodController {

	@Autowired
	private BloodService bloodService;

	// TODO: POST
	@PostMapping(value = "/bloodStock/", produces = "application/json")
	public Blood addBloodStock(@RequestParam("bloodGroup") final String bloodGroup,
			@RequestParam("bloodType") final String bloodType, @RequestParam("bloodStock") final int bloodStock,
			@RequestParam("hospitalName") final String hospitalName) {

		final Hospital hospital = new Hospital(null, hospitalName, null, null);
		final Blood blood = new Blood(bloodGroup, bloodType, bloodStock, hospital);
		return bloodService.addBloodStockInHospital(blood);

	}

	@DeleteMapping("Blood")
	public void deleteBloood(@RequestParam("id") final int id) {
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
