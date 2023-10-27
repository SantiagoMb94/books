package com.example.Book.Author;

import com.example.Book.Author.Controller.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUseCaseAuthor {
    @Autowired
    private AuthorRepository authorRepository;

    public boolean deleteAuthor (Long id){
        if (authorRepository.existsById(id)){
            authorRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
