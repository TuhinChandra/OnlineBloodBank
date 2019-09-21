package com.online.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.bloodbank.model.AdminUsers;

public interface AdminRepository extends JpaRepository<AdminUsers, Long> {

	List<AdminUsers> findByFullNameAndPassword(String fullName, String password);

}
