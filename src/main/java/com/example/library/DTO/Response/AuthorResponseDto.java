package com.example.library.DTO.Response;






import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {

    
    

    private String firstName;

    private String lastName;
    
    private String country;
    
}
