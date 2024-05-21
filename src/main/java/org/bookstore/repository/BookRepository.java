package org.bookstore.repository;

import org.bookstore.model.Book;

import java.util.List;

public interface BookRepository {
    Book save(Book book);

    List<Book> getAll();
}
