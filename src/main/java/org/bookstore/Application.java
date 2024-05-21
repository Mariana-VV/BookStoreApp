package org.bookstore;

import java.math.BigDecimal;
import org.bookstore.model.Book;
import org.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                Book terminator =
                        new Book("terminator", "cameron", "1111", new
                                BigDecimal(1000), "cool book", "");
                Book taxi =
                        new Book("taxi", "tokin", "2222",
                                new BigDecimal(900), "bad book", "");
                Book matrix =
                        new Book("matrix", "nelson", "3333",
                                new BigDecimal(950), "so so", "");
                bookService.save(terminator);
                bookService.save(taxi);
                bookService.save(matrix);

                System.out.println(bookService.getAll());
            }
        };
    }
}
