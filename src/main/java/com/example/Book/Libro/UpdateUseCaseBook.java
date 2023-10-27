package com.example.Book.Libro;

import com.example.Book.Libro.Controller.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Optional;

@Service
public class UpdateUseCaseBook {
    @Autowired
    private BookRepository bookRepository;

    public boolean updateBook(Long id, Book updatedBook) {
        if (bookRepository.existsById(id)) {
            bookRepository.save(updatedBook);
            return true;
        } else {
            return false;
        }
    }
    public Book save(Book book) {
        return bookRepository.save(book);
    }


    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
}