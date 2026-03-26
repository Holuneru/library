package com.example.library.DTO.Response.ConstDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSimpleDto {
    private Long id;
    private String title;
    private Integer availableCopies;
}
