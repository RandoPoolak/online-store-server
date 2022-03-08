package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.models.Author;
import com.sda.onlinestoreserver.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/get_by_id/{id}")
    public Author getById(@PathVariable("id") long id) {
        return authorRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @PostMapping("/update")
    public void updateAuthor(@RequestBody Author author) {
        authorRepository.save(author);
    }

    @GetMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") long id) {
        authorRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void saveAuthor(@RequestBody Author author) {
        authorRepository.save(author);
    }
}
