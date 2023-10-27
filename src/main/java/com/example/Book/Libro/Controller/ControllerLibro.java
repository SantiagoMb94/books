package com.example.Book.Libro.Controller;

import com.example.Book.Libro.CreateUseCaseBook;
import com.example.Book.Libro.DeleteUseCaseBook;
import com.example.Book.Libro.GetUseCaseBook;
import com.example.Book.Libro.UpdateUseCaseBook;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.Book.Libro.Book;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@NoArgsConstructor
@Service
@RequestMapping("/libro")

public class ControllerLibro {

    @Autowired
    private GetUseCaseBook getUseCaseBook;
    @Autowired
    private CreateUseCaseBook createUseCaseBook;
    @Autowired
    private UpdateUseCaseBook updateUseCaseBook;
    @Autowired
    private DeleteUseCaseBook deleteUseCaseBook;

    @GetMapping
    public List<java.awt.print.Book> getAllBooks() {
        return getUseCaseBook.getAllBooks();
    }

    @GetMapping("/")
    public ResponseEntity<java.awt.print.Book> getBookById(@PathVariable Long id) {
        Optional<java.awt.print.Book> optionalBook = getUseCaseBook.getBookById(id);
        return optionalBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = (Book) createUseCaseBook.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

   @PutMapping("/")
   public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
       Optional<java.awt.print.Book> optionalBook = updateUseCaseBook.findById(id);
       if (optionalBook.isPresent()) {
           Book existingBook = (Book) optionalBook.get();
           existingBook.setTitle(book.getTitle());
           existingBook.setAuthorId(book.getAuthorId());
           existingBook.setPublicationYear(book.getPublicationYear());
           existingBook.setGenre(book.getGenre());
           Book updatedBook = (Book) updateUseCaseBook.save(existingBook);
           return ResponseEntity.ok(updatedBook);
       } else {
           return ResponseEntity.notFound().build();
       }
   }
    @DeleteMapping("/")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (!deleteUseCaseBook.deleteBook(id)) {
            return ResponseEntity.notFound().build();
        }
        deleteUseCaseBook.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}