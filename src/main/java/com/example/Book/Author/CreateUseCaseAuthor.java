package com.example.Book.Author;

import com.example.Book.Author.Controller.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUseCaseAuthor {
    @Autowired
    private AuthorRepository authorRepository;

    public CreateUseCaseAuthor(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }
}
