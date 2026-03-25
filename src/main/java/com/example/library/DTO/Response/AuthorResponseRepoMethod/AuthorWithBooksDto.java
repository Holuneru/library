package com.example.library.DTO.Response.AuthorResponseRepoMethod;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorWithBooksDto {
    private Long id;
    private String authorFullName;
    private List<BookSimpleDto> books;
}
