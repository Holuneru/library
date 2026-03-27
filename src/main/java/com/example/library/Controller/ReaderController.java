package com.example.library.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.DTO.Request.ReaderRequestDto;
import com.example.library.DTO.Response.ReaderResponseDto;
import com.example.library.DTO.Response.ReaderResponseRepoMethod.ReaderWithLoansDto;
import com.example.library.Service.ReaderService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/readers")
public class ReaderController {
    private final ReaderService readerService;

    @PostMapping(path = "/registration")
    public ReaderResponseDto registrationReader(@RequestBody ReaderRequestDto request) {
        return readerService.registrationReader(request);
    }

    @GetMapping(path = "/{id}/loans")
    public ReaderWithLoansDto getLoansOfReader(@PathVariable Long id) {
        return readerService.getLoansOfReader(id);
    }
    
    
}
