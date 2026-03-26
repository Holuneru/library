package com.example.library.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.library.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    
    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.author WHERE b.id = :id")
    Optional<Book> findWithAuthor(@Param("id") Long id);

    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.loans WHERE b.id = :id")
    Optional<Book> findWithLoans(@Param("id") Long id);
}
