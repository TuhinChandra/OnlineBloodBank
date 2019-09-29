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
	public Requisition addRequisition(@RequestParam(value = "registrationNumber") final String registrationNumber,
			@RequestParam("bloodType") final String bloodType, @RequestParam("reqBloodUnit") final int reqBloodUnit) {
		return requisitionService.addRequisition(bloodType, reqBloodUnit, registrationNumber);
	}

	@PutMapping(value = "/process", produces = "application/json")
	public Requisition processRequisition(@RequestParam("id") final long id,
			@RequestParam("reqStatus") final Status reqStatus, @RequestParam("bloodType") final String bloodType,
			@RequestParam(value = "hospitalId", required = false) final long hospitalId) {
		final Requisition requisition = requisitionService.processRequisition(id, reqStatus, bloodType, hospitalId);
		return requisition;
	}
}
