package com.example.library.Service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.DTO.Request.LoanRequest;
import com.example.library.DTO.Response.LoanResponse;
import com.example.library.Entity.Book;
import com.example.library.Entity.Loan;
import com.example.library.Entity.Reader;
import com.example.library.Repository.BookRepository;
import com.example.library.Repository.LoanRepository;
import com.example.library.Repository.ReaderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanService {
    private final LoanRepository loanRepository;
    private final ReaderRepository readerRepository;
    private final BookRepository bookRepository;
    @Transactional
    public LoanResponse createLoan(LoanRequest request){
        Reader reader = readerRepository.findById(request.getReaderId()).orElseThrow(()-> new RuntimeException("Читатель не найден"));
        Book book = bookRepository.findById(request.getBookId()).orElseThrow(()-> new RuntimeException("Книга не найдена"));
        if (book.getAvailableCopies()<0) {
            throw new RuntimeException("Копии книг отсутствуют");
        }
        book.setAvailableCopies(book.getAvailableCopies()-1);
        bookRepository.save(book);
        log.info("Информация о книге перезаписанна");
        
        Loan loan = new Loan();
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now());
        loan.setDuenDate(LocalDate.now().plusDays(30));
        loan.setReader(reader);
        loan.setReturnDate(null);
        
        loanRepository.save(loan);
        log.info("Выдача сделанна");

        LoanResponse response = new LoanResponse(loan.getId(), reader.getFirstName()+" "+reader.getLastName(), book.getTitle(), loan.getLoanDate(), loan.getDuenDate(), loan.getReturnDate());
        return response;
    }
    
}
