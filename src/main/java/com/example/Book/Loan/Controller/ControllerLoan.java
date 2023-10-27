package com.example.Book.Loan.Controller;

import com.example.Book.Loan.Loan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ControllerLoan {
    /*private final LoanRepository loanRepository;

    public ControllerLoan(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @GetMapping("/")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        return optionalLoan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Loan createdLoan = loanRepository.save(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLoan);
    }

    @PutMapping("/")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loan) {
        if (!loanRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        loan.setId(id);
        Loan updatedLoan = loanRepository.save(loan);
        return ResponseEntity.ok(updatedLoan);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        if (!loanRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        loanRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }*/
}