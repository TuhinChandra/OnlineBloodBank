package com.online.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.bloodbank.model.Blood;

public interface BloodRepository extends JpaRepository<Blood, Long> {

}
