package com.example.library.Controller.Admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.DTO.Response.AuthorResponseRepoMethod.AuthorWithBooksDto;

import com.example.library.Service.AuthorService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin/authors")
public class AdminAuthorController {
    private final AuthorService authorService;

    @GetMapping
    public List<AuthorWithBooksDto> findAllWithBooks() {
        return authorService.adminFullAuthorList();
    }
    
    
}
