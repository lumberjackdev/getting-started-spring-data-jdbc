package com.lumberjackdev.jdbcexample.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount implements GeneratedId {
    @Id
    private String id;
    private String name;
    private String email;

    @MappedCollection(idColumn = "id", keyColumn = "address_id")
    private Address address;
}
