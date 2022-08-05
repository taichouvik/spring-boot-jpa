package com.example.jpa;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BookController {

    public final BookService bookService;

    @GetMapping("/authors/{authorId}/books")
    public List<BookDto> getBooks(@PathVariable int authorId) {
        return bookService.getBooks(authorId);
    }

    @PostMapping("/authors/{authorId}/books")
    public BookDto addBook(@PathVariable int authorId, @RequestBody BookDto bookDto) {
        return bookService.addBook(authorId, bookDto);
    }

    @GetMapping("/authors/{authorId}/books/{id}")
    public BookDto getBook(@PathVariable int authorId, @PathVariable int id) {
        return bookService.getBook(authorId, id);
    }

    @PostMapping("/filter")
    public List<BookDto> getBook(@RequestBody List<Filter> filter) {
        return bookService.getBookFiltered(filter);
    }
}
