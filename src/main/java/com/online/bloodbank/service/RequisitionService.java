package com.online.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.enums.Status;
import com.online.bloodbank.model.Patient;
import com.online.bloodbank.model.Requisition;
import com.online.bloodbank.repository.RequisitionRepository;

@Service
public class RequisitionService {

	@Autowired
	private PatientService patientService;
	@Autowired
	RequisitionRepository requisitionRepository;

	public Requisition addRequisition(final String patientName, final int reqBloodUnit,
			final String registrationNumber) {
		final Patient patient = patientService.findPatient(patientName);
		final Requisition requisition = new Requisition(Status.SUBMITTED, reqBloodUnit, patient, registrationNumber);
		return requisitionRepository.save(requisition);

	}

	public List<Requisition> getAllRequisition() {
		final List<Requisition> listRequisition = requisitionRepository.findAll();
		return listRequisition;
	}

	public Requisition processRequisition(final long id, final Status reqStatus) {
		final List<Requisition> listRequisition = requisitionRepository.findById(id);
		if (listRequisition.isEmpty()) {
			return null;
		} else {
			final Requisition requisition = listRequisition.get(0);
			requisition.setReqStatus(reqStatus);
			return requisitionRepository.save(requisition);
		}
	}

}
