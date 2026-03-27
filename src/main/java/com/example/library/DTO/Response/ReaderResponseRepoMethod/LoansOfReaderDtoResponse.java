package com.example.library.DTO.Response.ReaderResponseRepoMethod;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoansOfReaderDtoResponse {
    private Long id;
    private LocalDate loanDate;
    private LocalDate duenDate;
    private LocalDate returnDate;
}
