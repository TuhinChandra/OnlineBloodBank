package com.online.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.bloodbank.model.AdminUser;

public interface AdminRepository extends JpaRepository<AdminUser, Long> {

	List<AdminUser> findByFullNameAndPassword(String fullName, String password);

}
