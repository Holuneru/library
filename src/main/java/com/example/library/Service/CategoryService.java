package com.example.library.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.DTO.Request.CategoryRequest;
import com.example.library.DTO.Response.CategoryResponse;
import com.example.library.DTO.Response.CategoryResponseRepoMethod.CategoryWithBooksDto;
import com.example.library.DTO.Response.ConstDto.BookSimpleDto;
import com.example.library.Entity.Category;
import com.example.library.Repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;


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

    public CategoryWithBooksDto getWhithBooks(Long id){
        Category category = categoryRepository.findWithBooks(id)
            .orElseThrow(() -> new RuntimeException("Категория не найдена"));
        if (category.getBooks().isEmpty()) {
            throw new RuntimeException("В этой категории еще нет книг");
        }

        List<BookSimpleDto> booksOfCategory = category.getBooks().stream().map(book ->  new BookSimpleDto(book.getId(), book.getTitle(), book.getAvailableCopies())).toList();
        return new CategoryWithBooksDto(category.getName(), category.getDescription(), booksOfCategory);
    }

}
