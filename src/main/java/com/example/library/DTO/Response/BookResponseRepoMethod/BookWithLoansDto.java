package com.example.library.DTO.Response.BookResponseRepoMethod;

import java.util.List;

import com.example.library.DTO.Response.ConstDto.LoanSimplDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookWithLoansDto {
    private Long id;
    private String title;
    private List<LoanSimplDto> loans;
    
}
