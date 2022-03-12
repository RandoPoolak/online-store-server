package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.exceptions.CategoryNotFoundException;
import com.sda.onlinestoreserver.models.Category;
import com.sda.onlinestoreserver.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id){
        try {
            Category category = categoryService.findById(id);
            return new ResponseEntity<>(category, HttpStatus.FOUND);

        } catch (CategoryNotFoundException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Category> getAll(){return categoryService.getAll();}

    @PostMapping("/update")
    public void updateCategory(@RequestBody Category category){
        try{
            categoryService.updateCategory(category);
        }catch (CategoryNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") long id){
        try{
            categoryService.deleteCategoryById(id);
        }catch (CategoryNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @PostMapping("/save")
    public void createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }
}
