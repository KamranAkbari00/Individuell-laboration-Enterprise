package com.exemple.wigellmember.repository;

import com.exemple.wigellmember.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
