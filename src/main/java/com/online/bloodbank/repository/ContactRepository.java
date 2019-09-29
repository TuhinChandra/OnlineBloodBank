package com.online.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.bloodbank.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
	List<Contact> findById(long id);

	List<Contact> findByEmailID(String emailID);
}
