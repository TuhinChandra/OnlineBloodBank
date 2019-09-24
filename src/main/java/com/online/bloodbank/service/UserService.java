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
		final Users userSaved = userRepository.save(user);
		return userSaved;
	}

	public Users findByIDUsers(final String fullName, final String password) {
		final List<Users> userList = userRepository.findByFullNameAndPassword(fullName, password);
		if (userList.isEmpty()) {
			return null;
		} else {
			return userList.get(0);
		}
	}

	public Users loginUsers(final String fullName, final String password) {
		final Users users = findByIDUsers(fullName, password);
		if (users.getPassword().equals(password)) {
			return users;
		} else {
			return null;
		}
	}

}
