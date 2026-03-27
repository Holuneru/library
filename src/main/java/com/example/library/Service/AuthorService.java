package com.example.library.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.DTO.Request.AuthorRequestDto;

import com.example.library.DTO.Response.AuthorResponseDto;
import com.example.library.DTO.Response.AuthorResponseRepoMethod.AuthorWithBooksDto;
import com.example.library.DTO.Response.ConstDto.BookSimpleDto;
import com.example.library.Entity.Author;
import com.example.library.Repository.AuthorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {
    private final AuthorRepository authorRepository;

    //admin
    public List<AuthorWithBooksDto> adminFullAuthorList() {
    List<Author> authors = authorRepository.findAllWithBooks();
    
    return authors.stream().map(author -> {
        AuthorWithBooksDto dto = new AuthorWithBooksDto();
        dto.setId(author.getId());
        dto.setAuthorFullName(author.getFirstName() + " " + author.getLastName());
        
        if (author.getBooks() != null) {
            List<BookSimpleDto> bookSimpleDtos = author.getBooks().stream()
                .map(book -> new BookSimpleDto(
                    book.getId(), 
                    book.getTitle(), 
                    book.getAvailableCopies()
                ))
                .toList();
            
            // 1. Обязательно сеттим список книг в DTO
            dto.setBooks(bookSimpleDtos); 
        }
        
        // 2. Возвращаем объект dto для каждой итерации map
        return dto; 
    }).toList();
}
    //admin

    @Transactional
    public AuthorResponseDto createAuthor(AuthorRequestDto request){
        Author author = new Author();
        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());
        author.setCountry(request.getCountry());
        author.setBirthDate(request.getBirthDate());

        authorRepository.save(author);

        log.info("Author saved by id: {}", author.getId());
        
        AuthorResponseDto response = new AuthorResponseDto(author.getFirstName(), author.getLastName(), author.getCountry());

        log.info("ResponseAuthor Created");

        return response;
    }

    public AuthorWithBooksDto getAuthorWithBooks(Long id){
        Author author = authorRepository.findAuthorWithBooks(id)
            .orElseThrow(()-> new RuntimeException("Автор не найден"));
        List<BookSimpleDto> booksDto = author.getBooks().stream()
            .map(book -> new BookSimpleDto(book.getId(), book.getTitle(), book.getAvailableCopies())).toList();
        return new AuthorWithBooksDto(id, author.getFirstName()+" "+author.getLastName(), booksDto);
    }

}
