package com.online.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.service.HospitalService;

@RestController

public class HospitalController {

	/*
	 * @Autowired private HospitalRepository hospitalRepository;
	 */

	@Autowired
	private AddressController addressController;

	@Autowired
	private ContactController contactController;

	@Autowired
	private HospitalService hospitalService;

	/*
	 * @GetMapping(value = "/register/hospital", produces = "application/json")
	 * public Hospital getHospital() { final Address address = new
	 * Address("Kolkata", "New Town", 700056, "West Bengal"); final Contact contact
	 * = new Contact("TMC Admin", "tmc@hotmail.com", 9); final Hospital hospital =
	 * new Hospital("TMC Kolkata", "TMC001", address, contact);
	 * hospitalRepository.save(hospital); return hospital; }
	 */

	/*
	 * @RequestMapping(value =
	 * "/registerHospital/{hospitalName}/{registrationNo}/{city}/{streetNo}/{pinCode}/{state}/{contactName}/{emailID}/{contactNo}",
	 * method = RequestMethod.GET, produces = "application/json")
	 *
	 * @ResponseBody public Hospital registerHospital(@PathVariable("hospitalName")
	 * final String hospitalName,
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
	 * final Address address = addressController.createAddress(city, streetNo,
	 * pinCode, state);
	 *
	 * final Contact contact = contactController.createContact(contactName, emailID,
	 * contactNo); return hospitalService.register(hospitalName, registrationNo,
	 * address, contact); }
	 */

	/*
	 * @RequestMapping(value = "/findHospital/{hospitalName}", method =
	 * RequestMethod.GET, produces = "application/json")
	 *
	 * @ResponseBody public Hospital
	 * findByHospitalName(@PathVariable("hospitalName") final String hospitalName) {
	 * final Hospital hospital = hospitalService.findByHospitalName(hospitalName);
	 * return hospital;
	 *
	 * }
	 *
	 * @RequestMapping(value = "/findHospital/{ID}", method = RequestMethod.GET,
	 * produces = "application/json")
	 *
	 * @ResponseBody public Hospital findByHospitalID(@PathVariable("ID") final long
	 * ID) { final Hospital hospital = hospitalService.findByHospitalID(ID); return
	 * hospital; }
	 */
}
