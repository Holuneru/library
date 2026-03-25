package com.example.library.Service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.library.DTO.Request.ReaderRequestDto;
import com.example.library.DTO.Response.ReaderResponseDto;
import com.example.library.Entity.Reader;
import com.example.library.Repository.ReaderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderResponseDto registrationReader(ReaderRequestDto request){
        Reader reader = new Reader();
        reader.setFirstName(request.getFirstName());
        reader.setLastName(request.getLastName());
        reader.setEmail(request.getEmail());
        reader.setRegistrationDate(LocalDate.now());
        readerRepository.save(reader);
        log.info("Читатель зарегистрировался под id {}", reader.getId());
        ReaderResponseDto response = new ReaderResponseDto(reader.getId(),reader.getFirstName(), reader.getLastName(), reader.getEmail(), reader.getRegistrationDate());
        return response;
    }

}
