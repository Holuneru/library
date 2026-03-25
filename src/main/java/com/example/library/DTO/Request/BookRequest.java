package com.example.library.DTO.Request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    
    @NotBlank(message = "Название книги обязательно")
    private String title;

    @NotBlank(message = "ISBN обязателен")
    @Size(min = 10, max = 13, message = "ISBN должен содержать от 10 до 13 символов")
    private String isbn;

    @NotNull(message = "Год издания обязателен")
    private Integer publishedYear;

    @NotNull(message = "Общее количество экземпляров обязательно")
    @PositiveOrZero(message = "Количество экземпляров не может быть отрицательным")
    private Integer totalCopies;

    @NotNull(message = "ID автора обязателен")
    private Long authorId;

    @NotNull(message = "ID категории обязателен")
    private Long categoryId;
}
