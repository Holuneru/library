package com.example.library.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.DTO.Request.CategoryRequest;
import com.example.library.DTO.Response.CategoryResponse;
import com.example.library.Entity.Category;
import com.example.library.Repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    //admin
    public List<Category> adminFullCategoriesList(){
        return categoryRepository.findAll();
    }
    //admin


    @Transactional
    public CategoryResponse createCategory(CategoryRequest request){

        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        
        categoryRepository.save(category);

        log.info("category saved by id {}",category.getId());

        CategoryResponse response = new CategoryResponse(category.getName(), category.getDescription());
        log.info("Response created");
        return response;
    }

}
