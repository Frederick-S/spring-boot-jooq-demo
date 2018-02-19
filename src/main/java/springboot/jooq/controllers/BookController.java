package springboot.jooq.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springboot.jooq.models.Book;

import java.util.concurrent.Callable;

@RestController
public class BookController {
    @GetMapping("/books/{id}")
    public Callable<Book> book(@PathVariable Integer id) {
        return () -> new Book();
    }
}
