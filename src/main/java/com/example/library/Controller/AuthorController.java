package com.example.library.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.DTO.Request.AuthorRequestDto;
import com.example.library.DTO.Response.AuthorResponseDto;
import com.example.library.DTO.Response.AuthorResponseRepoMethod.AuthorWithBooksDto;

import com.example.library.Service.AuthorService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping(path = "/create")
    public AuthorResponseDto creatAuthor(@RequestBody AuthorRequestDto request) {
        return authorService.createAuthor(request);
    }
    
    @GetMapping(path = "/{id}/books")
    public AuthorWithBooksDto getBooksofAuthor(@PathVariable Long id) {
        return authorService.getAuthorWithBooks(id);
    }
    
    
}
