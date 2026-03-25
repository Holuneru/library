package com.example.library.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.DTO.Request.BookRequest;
import com.example.library.DTO.Response.BookResponseDto;
import com.example.library.Service.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public BookResponseDto createBook(@RequestBody BookRequest request) {
        return bookService.createBook(request);
    }
    
    
}
