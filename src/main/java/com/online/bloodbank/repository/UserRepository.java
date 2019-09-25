package com.online.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.bloodbank.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	List<Users> findByUserNameAndPassword(String userName, String password);

}
