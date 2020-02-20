package com.lumberjackdev.jdbcexample.repository;

import com.lumberjackdev.jdbcexample.domain.Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, String> {
}
