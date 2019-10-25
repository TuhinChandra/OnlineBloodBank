package com.online.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bloodbank.model.Users;
import com.online.bloodbank.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Users registerUser(final Users user) {
		final List<Users> userList = userRepository.findByMobileNo(user.getMobileNo());

		if (userList.isEmpty()) {
			userRepository.save(user);
		}
		return user;
	}

	public Users loginUsers(final String emailId, final String password) {
		Users user = null;
		final List<Users> userList = userRepository.findByEmailIdAndPassword(emailId, password);
		if (!userList.isEmpty()) {
			user = userList.get(0);
		}
		return user;
	}

}
