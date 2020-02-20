package com.lumberjackdev.jdbcexample.repository;

import com.lumberjackdev.jdbcexample.domain.InventoryItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends CrudRepository<InventoryItem, String > {
}
