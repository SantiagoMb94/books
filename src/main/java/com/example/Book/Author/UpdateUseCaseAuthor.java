package com.example.Book.Author;

import com.example.Book.Author.Controller.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUseCaseAuthor {
    @Autowired
    private AuthorRepository authorRepository;

    public Optional<Author> updateAuthor(Long id, Author updatedAuthor) {
        if (authorRepository.existsById(id)) {
            updatedAuthor.setAuthorId(id);
            return Optional.of(authorRepository.save(updatedAuthor));
        } else {
            return Optional.empty();
        }
    }


    public Author save(Author existingAuthor) {
        return authorRepository.save(existingAuthor);
    }
}