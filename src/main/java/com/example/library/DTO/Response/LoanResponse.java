package com.example.library.DTO.Response;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponse {
    
    private Long id;

    
    private String readerName;
    private String bookTitle;

    private LocalDate loanDate;
    private LocalDate duenDate;
    private LocalDate returnDate;
}
