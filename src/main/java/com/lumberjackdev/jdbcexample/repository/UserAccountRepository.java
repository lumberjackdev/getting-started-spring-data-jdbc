package com.lumberjackdev.jdbcexample.repository;

import com.lumberjackdev.jdbcexample.domain.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, String> {
}
