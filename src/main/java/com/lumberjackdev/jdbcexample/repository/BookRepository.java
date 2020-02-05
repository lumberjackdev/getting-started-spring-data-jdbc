package com.lumberjackdev.jdbcexample.repository;

import com.lumberjackdev.jdbcexample.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
