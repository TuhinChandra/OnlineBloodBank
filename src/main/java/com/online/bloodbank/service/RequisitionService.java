package com.online.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.enums.Status;
import com.online.bloodbank.model.Blood;
import com.online.bloodbank.model.Patient;
import com.online.bloodbank.model.Requisition;
import com.online.bloodbank.repository.RequisitionRepository;

@Service
public class RequisitionService {

	@Autowired
	private PatientService patientService;
	@Autowired
	private BloodService bloodService;
	@Autowired
	RequisitionRepository requisitionRepository;

	public Requisition addRequisition(final String patientName, final int reqBloodUnit,
			final String registrationNumber) {
		Requisition requisition = null;
		final Patient patient = patientService.findPatient(registrationNumber);
		if (null != patient) {
			requisition = new Requisition(Status.SUBMITTED, reqBloodUnit, patient.getId());
			requisitionRepository.save(requisition);
		}
		return requisition;
	}

	public List<Requisition> getAllRequisition() {
		final List<Requisition> listRequisition = requisitionRepository.findAll();
		return listRequisition;
	}

	public Requisition approveRequisition(final long id, final Status reqStatus, final String bloodType,
			final long hospitalId) {
		Requisition requisition = null;
		final List<Requisition> listRequisition = requisitionRepository.findById(id);
		if (!listRequisition.isEmpty()) {
			requisition = listRequisition.get(0);
			requisition.setReqStatus(reqStatus);
			if (reqStatus.equals(Status.APPROVED)) {
				// Update Blood Stock
				final int issuedStockQty = requisition.getReqBloodUnit();
				final long patientId = requisition.getPatient_id();
				final Patient patient = patientService.FindById(patientId);
				final String bloodGroup = patient.getBloodGroup();

				final Blood blood = bloodService.findByBloodGroupAndBloodTypeAndHospitalID(bloodGroup, bloodType,
						hospitalId);
				if (null != blood) {
					bloodService.updateBloodStockInHospital(blood, issuedStockQty, hospitalId);
					requisitionRepository.save(requisition);
				}

			}
		}
		return requisition;
	}

	public Requisition processRequisition(final long id, final Status reqStatus, final String bloodType,
			final long hospitalId) {
		Requisition requisition = null;

		if (reqStatus.equals(Status.APPROVED)) {
			if (hospitalId != 0) {
				requisition = approveRequisition(id, reqStatus, bloodType, hospitalId);
			} else {
				requisition = null;
			}
		} else {
			final List<Requisition> listRequisition = requisitionRepository.findById(id);
			if (!listRequisition.isEmpty()) {
				requisition = listRequisition.get(0);
				requisition.setReqStatus(reqStatus);
				requisitionRepository.save(requisition);
			}
		}
		return requisition;
	}

}
