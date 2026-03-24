package com.example.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.Entity.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    
}
