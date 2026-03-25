package com.example.library.DTO.Request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {

    private String firstName;

    private String lastName;

    private LocalDate birthDate;
    
    private String country;

    
}