package com.online.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.service.BloodService;

@RestController
public class BloodController {

	/*
	 * @Autowired private BloodRepository bloodRepository;
	 */

	@Autowired
	private BloodService bloodService;

	@Autowired
	private HospitalController hospitalController;

	/*
	 * @RequestMapping(value =
	 * "/registerBlood/{bloodGroup}/{bloodType}/{bloodStock}/{hospitalName}/{registrationNo}/{city}/{streetNo}/{pinCode}/{state}/{contactName}/{emailID}/{contactNo}",
	 * method = RequestMethod.GET, produces = "application/json")
	 *
	 * @ResponseBody public Blood registerBlood(@PathVariable("bloodGroup") final
	 * String bloodGroup,
	 *
	 * @PathVariable("bloodType") final String
	 * bloodType, @PathVariable("bloodStock") final int bloodStock,
	 *
	 * @PathVariable("hospitalName") final String hospitalName,
	 *
	 * @PathVariable("registrationNo") final String
	 * registrationNo, @PathVariable("city") final String city,
	 *
	 * @PathVariable("streetNo") final String streetNo, @PathVariable("pinCode")
	 * final long pinCode,
	 *
	 * @PathVariable("state") final String state, @PathVariable("contactName") final
	 * String contactName,
	 *
	 * @PathVariable("emailID") final String emailID, @PathVariable("contactNo")
	 * final long contactNo) throws Exception {
	 *
	 * // Hospital hospital = hospitalController.findByHospitalName(hospitalName);
	 * Blood blood = new Blood();
	 *
	 * if (hospital.getHospitalName().equals(hospitalName)) { blood =
	 * bloodService.addNewBloodStock(bloodGroup, bloodType, bloodStock, hospital); }
	 * else {
	 *
	 * final Hospital hospital = hospitalController.registerHospital(hospitalName,
	 * registrationNo, city, streetNo, pinCode, state, contactName, emailID,
	 * contactNo); blood = bloodService.addNewBloodStock(bloodGroup, bloodType,
	 * bloodStock, hospital);
	 *
	 * return blood;
	 *
	 * }
	 */

	/*
	 * @PostMapping(value = "/search/all/blood", produces = "application/json")
	 * public List<Blood> getAllBlood() { return bloodRepository.findAll(); }
	 */

}
