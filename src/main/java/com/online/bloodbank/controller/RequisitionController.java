package com.online.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.model.Requisition;
import com.online.bloodbank.service.RequisitionService;

@RestController
public class RequisitionController {

	@Autowired
	private RequisitionService requisitionService;

	@PostMapping(value = "/add/requisition", produces = "application/json")
	public Requisition addRequisition(@RequestParam("patientName") final String patientName,
			@RequestParam("reqBloodUnit") final int reqBloodUnit,
			@RequestParam("registrationNumber") final String registrationNumber) {
		return requisitionService.addRequisition(patientName, reqBloodUnit, registrationNumber);
	}
}
