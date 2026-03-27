package com.example.library.DTO.Response.ReaderResponseRepoMethod;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderWithLoansDto {

    private String readerName;
    private List<LoansOfReaderDtoResponse> loans;
    
}
