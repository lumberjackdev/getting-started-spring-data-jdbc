package com.lumberjackdev.jdbcexample.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse implements GeneratedId {
    @Id
    private String id;
    private String location;

    @Builder.Default
    @MappedCollection
    Set<InventoryItem> inventoryItems = new HashSet<>();

    public void addInventoryItem(InventoryItem inventoryItem) {
        var itemWithId = inventoryItem.toBuilder().id(UUID.randomUUID().toString()).build();
        this.inventoryItems.add(itemWithId);
    }
}
