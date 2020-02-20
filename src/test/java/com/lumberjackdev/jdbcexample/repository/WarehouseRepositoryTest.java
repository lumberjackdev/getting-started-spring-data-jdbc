package com.lumberjackdev.jdbcexample.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.lumberjackdev.jdbcexample.helpers.Stubs.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class WarehouseRepositoryTest {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    @Test
    void canSaveWarehouseWithManyItems() {
        var warehouse = stubWarehouse();
        var itemCount = randomNumber();

        for (int i = 0; i < itemCount; i++) {
            warehouse.addInventoryItem(stubInventoryItem());
        }

        var savedWarehouse = warehouseRepository.save(warehouse);

        assertThat(savedWarehouse.getInventoryItems()).hasSize(itemCount);
        warehouse.getInventoryItems().forEach(item -> assertThat(inventoryItemRepository.existsById(item.getId())).isTrue());
    }

    @Test
    void deletingWarehouseDeletesInventoryItems() {
        var warehouse = stubWarehouse();
        var itemCount = randomNumber();

        for (int i = 0; i < itemCount; i++) {
            warehouse.addInventoryItem(stubInventoryItem());
        }

        var savedWarehouse = warehouseRepository.save(warehouse);
        warehouse.getInventoryItems().forEach(item -> assertThat(inventoryItemRepository.existsById(item.getId())).isTrue());

        warehouseRepository.delete(savedWarehouse);
        warehouse.getInventoryItems().forEach(item -> assertThat(inventoryItemRepository.existsById(item.getId())).isFalse());
    }
}
