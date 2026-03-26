package com.example.library.DTO.Response.ConstDto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanSimplDto {
   
    
    private String readerName;
    private LocalDate loanDate;
    private LocalDate duenDate;
    private LocalDate returnDate;

    
    

    
}
