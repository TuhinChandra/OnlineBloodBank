package com.online.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.bloodbank.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	List<Hospital> findByhospitalName(String hospitalName);
}
