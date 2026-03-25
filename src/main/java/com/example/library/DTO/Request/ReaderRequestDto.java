package com.example.library.DTO.Request;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderRequestDto {
    
    private String firstName;
    private String lastName;
    private String email;
    
}
