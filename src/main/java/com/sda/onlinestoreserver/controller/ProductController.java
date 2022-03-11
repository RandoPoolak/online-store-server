package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.models.Product;
import com.sda.onlinestoreserver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/get_by_id/{id}")
    public Product getById(@PathVariable("id") long id){
        return productRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Product> getAll(){return productRepository.findAll();}

    @PostMapping("/update")
    public void updateAuthor(@RequestBody Product product){
        productRepository.save(product);
    }

    @GetMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") long id){
        productRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void saveAuthor(@RequestBody Product product){
        productRepository.save(product);
    }
}
