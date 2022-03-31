package com.example.jpa;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
public class AuthorDto {
    
    
    private int id;

    private String name;
    
    private List<BookDto> books = new ArrayList<>();

    public void addBook(BookDto book){
        books.add(book);
    }
}
