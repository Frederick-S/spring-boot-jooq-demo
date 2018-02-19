package springboot.jooq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springboot.jooq.dtos.BookDto;
import springboot.jooq.models.tables.records.BookRecord;
import springboot.jooq.services.BookService;

import java.util.concurrent.Callable;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books/{id}")
    public Callable<BookDto> book(@PathVariable Integer id) {
        return () -> {
            BookRecord bookRecord = this.bookService.findByPrimaryKey(id);

            BookDto bookDto = new BookDto();
            bookDto.setId(bookRecord.getId());
            bookDto.setTitle(bookRecord.getTitle());

            return bookDto;
        };
    }
}
