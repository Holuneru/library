package com.example.library.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private Long id;
    private String title;
    private String isbn;
    private Integer publishedYear;
    private Integer totalCopies;
    private Integer availableCopies;
    private String authorName;        // имя + фамилия автора
    private String categoryName;      // название категории
}
