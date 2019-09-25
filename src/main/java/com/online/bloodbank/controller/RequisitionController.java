package com.online.bloodbank.controller;

import static com.online.bloodbank.constant.APIBasePathConstant.REQUISITION_API_BASEPATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.bloodbank.enums.Status;
import com.online.bloodbank.model.Requisition;
import com.online.bloodbank.service.RequisitionService;

@RestController
@RequestMapping(value = REQUISITION_API_BASEPATH)
public class RequisitionController {

	@Autowired
	private RequisitionService requisitionService;

	@PostMapping(value = "/add", produces = "application/json")
	public Requisition addRequisition(@RequestParam("patientName") final String patientName,
			@RequestParam("reqBloodUnit") final int reqBloodUnit,
			@RequestParam(value = "registrationNumber", required = false) final String registrationNumber) {
		return requisitionService.addRequisition(patientName, reqBloodUnit, registrationNumber);
	}

	@PutMapping(value = "/process", produces = "application/json")
	public Requisition processRequisition(@RequestParam("id") final long id,
			@RequestParam("reqStatus") final Status reqStatus) {
		final Requisition requisition = requisitionService.processRequisition(id, reqStatus);
		return requisition;
	}
}
