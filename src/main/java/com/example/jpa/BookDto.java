package com.example.jpa;

import lombok.Data;

@Data
public class BookDto {
    
   
    private int id;

    private String name;

    private int price;

    private int  authorId;
}
