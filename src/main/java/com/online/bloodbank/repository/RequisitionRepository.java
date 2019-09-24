package com.online.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.bloodbank.enums.Status;
import com.online.bloodbank.model.Requisition;

public interface RequisitionRepository extends JpaRepository<Requisition, Long> {

	List<Requisition> findById(long id);

	List<Requisition> findByReqStatus(Status reqStatus);

}
