package com.example.library.DTO.Response.CategoryResponseRepoMethod;

import java.util.List;

import com.example.library.DTO.Response.ConstDto.BookSimpleDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryWithBooksDto {

    @NotBlank private String name;
    @NotBlank private String description;
    private List<BookSimpleDto> books;
      
}
