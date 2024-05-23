package org.bookstore.service;

import java.util.List;
import org.bookstore.dto.BookDto;
import org.bookstore.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    List<BookDto> findAll();

    BookDto getBookById(Long id);

    List<BookDto> getAllByName(String name);
}
