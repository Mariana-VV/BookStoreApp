package org.bookstore.service;

import org.bookstore.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> getAll();
}
