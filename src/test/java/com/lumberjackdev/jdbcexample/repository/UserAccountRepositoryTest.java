package com.lumberjackdev.jdbcexample.repository;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.lumberjackdev.jdbcexample.helpers.Stubs.stubAddress;
import static com.lumberjackdev.jdbcexample.helpers.Stubs.stubUser;
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

    @Test
    void deletingUserDeletesTheirAddress() {
        var address = stubAddress();
        var newUser = stubUser(address);

        var savedUser = userAccountRepository.save(newUser);
        var addressId = savedUser.getAddress().getId();

        userAccountRepository.delete(savedUser);

        assertThat(addressRepository.existsById(addressId)).isFalse();
    }
}
