package com.example.library.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.library.Entity.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    @Query("SELECT r FROM Reader r LEFT JOIN FETCH r.loans WHERE r.id = :id")
    Optional<Reader> findWithLoans(@Param("id") Long id);
    
    
}
