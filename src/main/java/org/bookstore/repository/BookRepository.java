package org.bookstore.repository;

import java.util.List;
import org.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    // @Query("from Book b where upper(b.title) like upper(:title) ")
    // @Query(value = "select * from books where upper(title) like upper(:title) ",
    // nativeQuery = true)
    List<Book> findAllByTitleIgnoreCase(String title);

}
