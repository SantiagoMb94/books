package com.example.Book.Libro;

import com.example.Book.Libro.Controller.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUseCaseBook {
    @Autowired
    private BookRepository bookRepository;

    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
