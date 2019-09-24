package com.online.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.model.AdminUsers;
import com.online.bloodbank.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public AdminUsers registerAdmin(final AdminUsers admin) {
		final AdminUsers adminSaved = adminRepository.save(admin);

		return adminSaved;
	}

	public AdminUsers findByIDAdminUsers(final String fullName, final String password) {
		final List<AdminUsers> adminList = adminRepository.findByFullNameAndPassword(fullName, password);
		if (adminList.isEmpty()) {
			return null;
		} else {
			return adminList.get(0);
		}
	}

	public AdminUsers loginAdmin(final String fullName, final String password) {
		final AdminUsers adminUsers = findByIDAdminUsers(fullName, password);
		if (adminUsers.getPassword().equals(password)) {
			return adminUsers;
		} else {
			return null;
		}
	}

}
