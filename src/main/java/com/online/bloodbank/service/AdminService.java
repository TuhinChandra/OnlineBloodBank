package com.online.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.exception.CustomException;
import com.online.bloodbank.model.AdminUser;
import com.online.bloodbank.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public AdminUser registerAdmin(final AdminUser admin) {
		AdminUser adminSaved = null;
		final List<AdminUser> adminList = adminRepository.findByEmailId(admin.getEmailId());
		if (adminList.isEmpty()) {
			adminSaved = adminRepository.save(admin);
		} else {
			throw new CustomException("Duplicate Record Entry");
		}
		return adminSaved;
	}

	public AdminUser loginAdmin(final String emailId, final String password) {
		AdminUser adminUser = null;
		final List<AdminUser> adminList = adminRepository.findByEmailIdAndPassword(emailId, password);
		if (!adminList.isEmpty()) {
			adminUser = adminList.get(0);
		} else {
			throw new CustomException("No Record Found");
		}
		return adminUser;
	}

	public AdminUser getAdminInfo(final String emailId) {
		AdminUser adminUser = null;
		final List<AdminUser> adminList = adminRepository.findByEmailId(emailId);
		if (adminList.isEmpty()) {
			throw new CustomException("No Record Found");
		} else {
			adminUser = adminList.get(0);
		}
		return adminUser;

	}

}
