package com.online.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.bloodbank.model.AdminUser;

public interface AdminRepository extends JpaRepository<AdminUser, Long> {

	List<AdminUser> findByEmailIdAndPassword(String emailId, String password);

	List<AdminUser> findByEmailId(String emailId);

	List<AdminUser> findByFullName(String fullName);
}
