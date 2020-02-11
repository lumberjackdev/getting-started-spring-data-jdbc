package com.lumberjackdev.jdbcexample.repository;

import com.lumberjackdev.jdbcexample.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void canSaveBook() {
        var book = Book.builder().author("Steven Erikson").title("Gardens of the Moon").build();
        var savedBook = bookRepository.save(book);

        assertThat(savedBook.getId()).isNotBlank();
        assertThat(savedBook.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(savedBook.getTitle()).isEqualTo(book.getTitle());

        assertThat(savedBook).isEqualTo(bookRepository.findById(savedBook.getId()).get());
    }
}