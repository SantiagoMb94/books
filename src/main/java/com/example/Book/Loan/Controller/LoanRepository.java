package com.example.Book.Loan.Controller;

import com.example.Book.Loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface LoanRepository extends JpaRepository<Loan, Long> {
}