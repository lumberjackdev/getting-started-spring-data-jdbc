package com.lumberjackdev.jdbcexample.repository;

import com.lumberjackdev.jdbcexample.domain.Book;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {

    @Query("select * from Book b where b.title = :title")
    Optional<Book> findByTitle(@Param("title") String title);
}
