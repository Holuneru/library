package com.example.library.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.library.Entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    
    @Query("SELECT l FROM Loan l LEFT JOIN FETCH l.book LEFT JOIN FETCH l.reader WHERE l.id = :id")
    Optional<Loan> findByWithDetalis(@Param("id") Long id);

}
