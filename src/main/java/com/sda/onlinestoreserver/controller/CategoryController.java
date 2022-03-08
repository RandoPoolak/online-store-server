package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.models.Category;
import com.sda.onlinestoreserver.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/get_by_id/{id}")
    public Category getById(@PathVariable("id") long id){
        return categoryRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Category> getAll(){return categoryRepository.findAll();}

    @PostMapping("/update")
    public void updateAuthor(@RequestBody Category category){
        categoryRepository.save(category);
    }

    @GetMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") long id){
        categoryRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void saveAuthor(@RequestBody Category category){
        categoryRepository.save(category);
    }
}
