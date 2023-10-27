package com.example.Book.Author.Controller;

import com.example.Book.Author.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Service
@RequestMapping("/author")
public class ControllerAuthor {
    @Autowired
    private AuthorRepository authorRepository;


   @Autowired
    private GetUseCaseAuthor getUseCaseAuthor;
    @Autowired
    private CreateUseCaseAuthor createUseCaseAuthor;
    @Autowired
    private UpdateUseCaseAuthor updateUseCaseAuthor;
    @Autowired
    private DeleteUseCaseAuthor deleteUseCaseAuthor;

    @GetMapping
    public List<Author> getAllAuthors() {
        return getUseCaseAuthor.getAllAuthor();
    }

    @GetMapping("/")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Optional<Author> optionalAuthor = getUseCaseAuthor.getAuthorById(id);
        return optionalAuthor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author createdAuthor = createUseCaseAuthor.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

    @PutMapping("/")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            Author existingAuthor = optionalAuthor.get();
            existingAuthor.setName(author.getName());
            existingAuthor.setNationality(author.getNationality());
            Author updatedAuthor = authorRepository.save(existingAuthor);
            return ResponseEntity.ok(updatedAuthor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        if (!authorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        deleteUseCaseAuthor.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}