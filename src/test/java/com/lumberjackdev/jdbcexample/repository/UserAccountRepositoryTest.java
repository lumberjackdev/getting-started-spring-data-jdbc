package com.lumberjackdev.jdbcexample.repository;

import com.github.javafaker.Faker;
import com.lumberjackdev.jdbcexample.domain.Address;
import com.lumberjackdev.jdbcexample.domain.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserAccountRepositoryTest {
    private static final Faker faker = new Faker();

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void canSaveUserWithAddress() {
        var address = stubAddress();
        var newUser = stubUser(address);

        var savedUser = userAccountRepository.save(newUser);

        assertThat(savedUser.getId()).isNotBlank();
        assertThat(savedUser.getAddress().getId()).isNotBlank();

        var foundUser = userAccountRepository.findById(savedUser.getId()).orElseThrow(IllegalStateException::new);
        var foundAddress = addressRepository.findById(foundUser.getAddress().getId()).orElseThrow(IllegalStateException::new);

        assertThat(foundUser).isEqualTo(savedUser);
        assertThat(foundAddress).isEqualTo(savedUser.getAddress());
    }

    private static UserAccount stubUser(Address address) {
        return UserAccount.builder()
                .name(faker.superhero().name())
                .email(faker.internet().emailAddress())
                .address(address)
                .build();
    }

    private static Address stubAddress() {
        return Address.builder()
                .city(faker.address().city())
                .state(faker.address().state())
                .zipcode(faker.address().zipCode())
                .street(faker.address().streetAddress())
                .build();
    }
}
