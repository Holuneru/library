package com.example.library.Controller.AdminController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Entity.Book;
import com.example.library.Service.BookService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin/books")
public class BookAdminController {
    private final BookService bookService;

    @GetMapping
    public List<Book> adminFullBooksList() {
        return bookService.adminFullBooksList();
    }
    

}
