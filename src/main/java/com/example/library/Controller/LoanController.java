package com.example.library.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.DTO.Request.LoanRequest;
import com.example.library.DTO.Response.LoanResponse;
import com.example.library.Service.LoanService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/loans")
public class LoanController {
    private final LoanService loanService;

    @PostMapping("/create")
    public LoanResponse createLoan(@RequestBody LoanRequest request) {
        
        return loanService.createLoan(request);
    }
    
}
