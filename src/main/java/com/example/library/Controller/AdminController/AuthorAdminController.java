package com.example.library.Controller.AdminController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Entity.Author;
import com.example.library.Service.AuthorService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(name = "/admin/authors")
@RequiredArgsConstructor
public class AuthorAdminController {
    private final AuthorService authorService;

    @GetMapping
    public List<Author> adminFullAuthorList() {
        return authorService.adminFullAuthorList();
    }
    
}
