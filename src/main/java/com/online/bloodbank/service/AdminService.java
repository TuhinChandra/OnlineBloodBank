package com.online.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.model.AdminUser;
import com.online.bloodbank.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public AdminUser registerAdmin(final AdminUser admin) {
		AdminUser adminSaved = null;
		final List<AdminUser> adminList = adminRepository.findByUserName(admin.getUserName());
		if (adminList.isEmpty()) {
			adminSaved = adminRepository.save(admin);
		}
		return adminSaved;
	}

	public AdminUser loginAdmin(final String userName, final String password) {
		AdminUser adminUser = null;
		final List<AdminUser> adminList = adminRepository.findByUserNameAndPassword(userName, password);
		if (!adminList.isEmpty()) {
			adminUser = adminList.get(0);
		}
		return adminUser;
	}

}
