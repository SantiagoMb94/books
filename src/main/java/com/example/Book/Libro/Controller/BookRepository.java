package com.example.Book.Libro.Controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
