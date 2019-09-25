package com.online.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.bloodbank.enums.BloodGroup;
import com.online.bloodbank.model.Blood;

public interface BloodRepository extends JpaRepository<Blood, Long> {

	List<Blood> findByBloodGroup(String bloodGroup);

	List<Blood> findByBloodGroupAndBloodType(String bloodGroup, String bloodType);

	List<Blood> findByBloodGroupAndBloodTypeAndHospitalId(BloodGroup bloodGroup, String bloodType, long hospitalId);
}
