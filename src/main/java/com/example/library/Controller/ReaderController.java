package com.example.library.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.DTO.Request.ReaderRequestDto;
import com.example.library.DTO.Response.ReaderResponseDto;
import com.example.library.Service.ReaderService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/readers")
public class ReaderController {
    private final ReaderService readerService;

    @PostMapping("/registration")
    public ReaderResponseDto registrationReader(@RequestBody ReaderRequestDto request) {
        
        
        return readerService.registrationReader(request);
    }
    
}
