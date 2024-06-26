package org.bookstore.mapper;

import java.util.List;
import org.bookstore.config.MapperConfig;
import org.bookstore.dto.BookDto;
import org.bookstore.dto.CreateBookRequestDto;
import org.bookstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto requestDto);

    List<BookDto> toDtoList(List<Book> books);
}
