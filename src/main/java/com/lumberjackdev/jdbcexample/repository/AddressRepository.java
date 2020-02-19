package com.lumberjackdev.jdbcexample.repository;

import com.lumberjackdev.jdbcexample.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, String> {
}
