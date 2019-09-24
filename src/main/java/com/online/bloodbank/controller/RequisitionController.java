package com.online.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.enums.Status;
import com.online.bloodbank.model.Requisition;
import com.online.bloodbank.service.RequisitionService;

@RestController
public class RequisitionController {

	@Autowired
	private RequisitionService requisitionService;

	@PostMapping(value = "/add/requisition", produces = "application/json")
	public Requisition addRequisition(@RequestParam("patientName") final String patientName,
			@RequestParam("reqBloodUnit") final int reqBloodUnit,
			@RequestParam(value = "registrationNumber", required = false) final String registrationNumber) {
		return requisitionService.addRequisition(patientName, reqBloodUnit, registrationNumber);
	}

	@PutMapping(value = "/process/requisition", produces = "application/json")
	public Requisition processRequisition(@RequestParam("id") final long id,
			@RequestParam("reqStatus") final Status reqStatus) {
		final Requisition requisition = requisitionService.processRequisition(id, reqStatus);
		return requisition;
	}

	@PutMapping(value = "/update/registrationNumber", produces = "application/json")
	public Requisition updateRegistrationNumber(@RequestParam("id") final long id,
			@RequestParam("registrationNumber") final String registrationNumber) {
		final Requisition requisition = requisitionService.updateRegistrationNumber(id, registrationNumber);
		return requisition;
	}
}
