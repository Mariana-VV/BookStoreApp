package org.bookstore.service.impl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.bookstore.dto.BookDto;
import org.bookstore.dto.CreateBookRequestDto;
import org.bookstore.mapper.BookMapper;
import org.bookstore.model.Book;
import org.bookstore.repository.BookRepository;
import org.bookstore.service.BookService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    public List<BookDto> findAll() {
        return bookMapper.toDtoList(bookRepository.findAll());
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cant fint book by id: " + id));
        return bookMapper.toDto(book);
    }

    public List<BookDto> findAllByTitle(String title) {
        return bookMapper.toDtoList(bookRepository.findAllByTitleIgnoreCase(title));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public BookDto update(Long id, CreateBookRequestDto requestDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cant find book by id " + id));
        Book bookToSave = bookMapper.toModel(requestDto);
        bookToSave.setId(book.getId());
        return bookMapper.toDto(bookRepository.save(bookToSave));
    }
}
