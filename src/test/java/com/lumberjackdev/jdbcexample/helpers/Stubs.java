package com.lumberjackdev.jdbcexample.helpers;

import com.github.javafaker.Faker;
import com.lumberjackdev.jdbcexample.domain.Address;
import com.lumberjackdev.jdbcexample.domain.InventoryItem;
import com.lumberjackdev.jdbcexample.domain.UserAccount;
import com.lumberjackdev.jdbcexample.domain.Warehouse;

public class Stubs {
    private static final Faker faker = new Faker();

    public static UserAccount stubUser(Address address) {
        return UserAccount.builder()
                .name(faker.superhero().name())
                .email(faker.internet().emailAddress())
                .address(address)
                .build();
    }

    public static Address stubAddress() {
        return Address.builder()
                .city(faker.address().city())
                .state(faker.address().state())
                .zipcode(faker.address().zipCode())
                .street(faker.address().streetAddress())
                .build();
    }

    public static Warehouse stubWarehouse() {
        return Warehouse.builder()
                .location(faker.lordOfTheRings().location())
                .build();
    }

    public static InventoryItem stubInventoryItem() {
        return InventoryItem.builder()
                .name(faker.beer().name())
                .count(faker.number().numberBetween(0, 750))
                .build();
    }

    public static int randomNumber() {
        return faker.number().numberBetween(0, 10);
    }
}
