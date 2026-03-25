package com.example.library.Controller.AdminController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Entity.Category;
import com.example.library.Service.CategoryService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin/categories")
public class CategoryAdminController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> adminFullCategoriesList() {
        return categoryService.adminFullCategoriesList();
    }
    
    
}
