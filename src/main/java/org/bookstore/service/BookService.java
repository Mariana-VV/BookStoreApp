package org.bookstore.service;

import java.util.List;
import org.bookstore.dto.BookDto;
import org.bookstore.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    List<BookDto> findAll();

    BookDto getBookById(Long id);

    List<BookDto> findAllByTitle(String name);

    void deleteById(Long id);

    BookDto update(Long id, CreateBookRequestDto requestDto);
}
