package com.example.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.Entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
