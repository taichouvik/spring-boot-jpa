package com.example.jpa;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AuthorController {

    public final AuthorService authorService;

    @GetMapping("/authors")
    public List<AuthorDto> getAuthors(){
        return authorService.getAuthors();
    }
    
    @PostMapping("/authors")
    public Author addAuthor(@RequestBody AuthorDto authorDto){
        return authorService.addAuthor(authorDto);
    }

    @GetMapping("/authors/{id}")
    public AuthorDto  getAuthor(@RequestParam int id){
        return authorService.getAuthor(id);
    }
}
