package com.example.library.Service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.DTO.Request.BookRequest;
import com.example.library.DTO.Response.BookResponseDto;
import com.example.library.Entity.Author;
import com.example.library.Entity.Book;
import com.example.library.Entity.Category;
import com.example.library.Repository.AuthorRepository;
import com.example.library.Repository.BookRepository;
import com.example.library.Repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    

    @Transactional
    public BookResponseDto createBook(BookRequest request){
        Author author = authorRepository.findById(request.getAuthorId()).orElseThrow(()-> new RuntimeException("Автор не найден"));
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(()-> new RuntimeException("Категория не найдена"));
        
        Book newBook = new Book();
        newBook.setAuthor(author);
        newBook.setTitle(request.getTitle());
        newBook.setTotalCopies(request.getTotalCopies());
        newBook.setAvailableCopies(request.getTotalCopies());
        newBook.setIsbn(request.getIsbn());
        newBook.setCategory(category);
        newBook.setPublishedYear(request.getPublishedYear());

        bookRepository.save(newBook);
        log.info("Книга созданна под id {}",newBook.getId());

        BookResponseDto response = new BookResponseDto(newBook.getId(),newBook.getTitle(), newBook.getIsbn(), newBook.getPublishedYear(), newBook.getTotalCopies(), newBook.getAvailableCopies(), author.getFirstName()+" "+author.getLastName(), category.getName());

        return response;

    }

    public BookResponseDto deleteBook(Long id){
        Book book = bookRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Книги не существует"));
        BookResponseDto response = new BookResponseDto(id, book.getTitle(), book.getIsbn(), book.getPublishedYear(), book.getTotalCopies(), book.getAvailableCopies(), book.getAuthor().getFirstName()+" "+book.getAuthor().getLastName(), book.getCategory().getName());
        bookRepository.delete(book);
        return response;
    }

    

}
