package com.online.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.bloodbank.model.Requisition;

public interface RequisitionRepository extends JpaRepository<Requisition, Long> {

}
