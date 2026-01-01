package com.murtuzarahman.ecommerce.repositories;

import com.murtuzarahman.ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
