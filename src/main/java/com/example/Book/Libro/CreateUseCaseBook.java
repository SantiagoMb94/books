package com.example.Book.Libro;
import java.awt.print.Book;

import com.example.Book.Libro.Controller.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUseCaseBook {
    @Autowired
    private  BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
