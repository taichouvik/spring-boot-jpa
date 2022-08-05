package com.example.jpa;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {

    public final AuthorRepo authorRepo;
    public final ModelMapper modelMapper;

    AuthorDto getAuthor(int id){
        Author author = authorRepo.findById(id).orElseThrow();
        return modelMapper.map(author, AuthorDto.class);

    }

    public List<AuthorDto> getAuthors(){
        return authorRepo
        .findAll()
        .stream()
        .map((t) -> modelMapper.map(t, AuthorDto.class))
        .collect(Collectors.toList()); 
    }

    public Author addAuthor(AuthorDto authorDto){
        Author author = modelMapper.map(authorDto, Author.class);
        return authorRepo.save(author);

    }
}
