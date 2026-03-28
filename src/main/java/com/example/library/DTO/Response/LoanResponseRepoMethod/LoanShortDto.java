package com.example.library.DTO.Response.LoanResponseRepoMethod;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanShortDto {
    private Long id;
    private String readerLastName;
    private Long idReader;
    private LocalDate loanDate;
    private LocalDate duenDate;
}
