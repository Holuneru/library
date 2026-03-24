package com.example.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    
}
