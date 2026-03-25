package com.example.library.DTO.Response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderResponseDto {
    Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate registrationDate;
    
}
