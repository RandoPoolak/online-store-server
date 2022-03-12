package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.exceptions.ProductNotFoundException;
import com.sda.onlinestoreserver.models.Product;
import com.sda.onlinestoreserver.repository.ProductRepository;
import com.sda.onlinestoreserver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id){
        try{
            Product product = productService.findById(id);
            return new ResponseEntity<>(product, HttpStatus.FOUND);
        }catch (ProductNotFoundException e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Product> getAll(){return productService.getAll();}

    @PostMapping("/update")
    public void updateProduct(@RequestBody Product product){
        try{
            productService.updateProduct(product);
        }catch (ProductNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        try{
            productService.deleteProductById(id);
        }catch (ProductNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @PostMapping("/save")
    public void saveProduct(@RequestBody Product product){
        productService.createProduct(product);
    }
}
