package com.example.Book.Libro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@Data
@Table(name = "libro")
public class Book extends java.awt.print.Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "bookId")
    private Long bookId;
    @Column(name = "title")
    private String title;

    //@ManyToOne
   // @JoinColumn(name = "authorId")
    @Column(name = "authorId")
    private Long authorId;
    @Column(name = "publicationYear")
    private int publicationYear;
    @Column(name = "genre")
    private String genre;

    // Getters and setters


}



