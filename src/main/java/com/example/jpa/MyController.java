package com.example.jpa;



import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.utility.RandomString;

@RestController
public class MyController {
    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/add")
    public List<AuthorDto> addAuthorAndBook(){
        authorRepo.save(createAuthor());
        return authorRepo
        .findAll()
        .stream()
        .map((t) -> modelMapper.map(t, AuthorDto.class))
        .collect(Collectors.toList()); 
    }
    
    public Author createAuthor(){
        Author author = new Author();
        author.setName(RandomString.make());
        Book book = new Book();
        book.setName(RandomString.make());
        author.addBook(book);
        return author;
    }
}
