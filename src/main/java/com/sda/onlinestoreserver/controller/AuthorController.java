package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.exceptions.AuthorNotFoundException;
import com.sda.onlinestoreserver.models.Author;
import com.sda.onlinestoreserver.repository.AuthorRepository;
import com.sda.onlinestoreserver.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        try{
            Author author = authorService.findById(id);
            return new ResponseEntity<>(author, HttpStatus.FOUND);
        }catch (AuthorNotFoundException e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @PostMapping("/update")
    public void updateAuthor(@RequestBody Author author) {
        try{
            authorService.updateAuthor(author);
        }catch (AuthorNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") long id) {
        try{
            authorService.deleteAuthorById(id);
        }catch (AuthorNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/restore/{id}")
    public void restoreAuthor(@PathVariable("id") long id) {
        try{
            authorService.restoreAuthorById(id);
        }catch (AuthorNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @PostMapping("/save")
    public void createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
    }
}
