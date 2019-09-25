package com.online.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.online.bloodbank.model.Blood;

public interface BloodRepository extends JpaRepository<Blood, Long> {

	List<Blood> findByBloodGroup(String bloodGroup);

	List<Blood> findByBloodGroupAndBloodType(String bloodGroup, String bloodType);

//	@Query(nativeQuery = true, value = "SELECT b.* FROM blood b  and hospital h WHERE b.hospital_id = h.id AND b.blood_group = ?1 AND b.blood_type=?2")
	List<Blood> findByBloodGroupAndBloodTypeAndHospitalId(String bloodGroup, String bloodType, long hospitalId);
}
