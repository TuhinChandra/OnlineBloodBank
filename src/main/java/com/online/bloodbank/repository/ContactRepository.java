package com.online.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.bloodbank.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

}
