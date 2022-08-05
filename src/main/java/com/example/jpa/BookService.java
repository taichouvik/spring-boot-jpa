package com.example.jpa;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    public final BookRepo bookRepo;
    public final ModelMapper modelMapper;
    public final AuthorRepo authorRepo;
    public final CustomBookRepo customBookRepo;

    BookDto getBook(int authorId, int id) {
        Book book = bookRepo.findById(id).orElseThrow();
        return modelMapper.map(book, BookDto.class);

    }

    public List<BookDto> getBooks(int authorId) {
        return bookRepo
                .findByAuthorId(authorId)
                .stream()
                .map((t) -> modelMapper.map(t, BookDto.class))
                .collect(Collectors.toList());
    }

    public BookDto addBook(int authorId, BookDto bookDto) {
        // use instead of findById to get parents refernce
        Author author = authorRepo.getById(authorId);
        Book book = modelMapper.map(bookDto, Book.class);
        book.setAuthor(author);
        Book newBook = bookRepo.save(book);
        BookDto newBookDto = modelMapper.map(newBook, BookDto.class);
        newBookDto.setAuthorId(newBook.getAuthor().getId());
        return newBookDto;
    }

    public List<BookDto> getBookFiltered(List<Filter> filter) {
        return customBookRepo
        .getQueryResult(filter)
        .stream()
        .map((t) -> modelMapper.map(t, BookDto.class))
        .collect(Collectors.toList());
    }
}
