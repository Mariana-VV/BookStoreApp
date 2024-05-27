package org.bookstore.repository;

import java.util.List;
import org.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitleIgnoreCase(String title);

}
