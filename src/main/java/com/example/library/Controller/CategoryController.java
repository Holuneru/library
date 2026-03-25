package com.example.library.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.DTO.Request.CategoryRequest;
import com.example.library.DTO.Response.CategoryResponse;
import com.example.library.Service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    
    @PostMapping("/create")
    public CategoryResponse createCategory(@RequestBody CategoryRequest request) {
        return categoryService.createCategory(request);
    }
    
}
