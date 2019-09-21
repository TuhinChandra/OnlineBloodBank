package com.online.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.bloodbank.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
