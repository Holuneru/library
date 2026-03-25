package com.example.library.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.DTO.Request.AuthorRequestDto;
import com.example.library.DTO.Response.AuthorResponseDto;
import com.example.library.Service.AuthorService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/create")
    public AuthorResponseDto creatAuthor(@RequestBody AuthorRequestDto request) {
        return authorService.createAuthor(request);
    }
    
    
}
