package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.models.ProductType;
import com.sda.onlinestoreserver.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_type")
public class ProductTypeController {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @GetMapping("/get_by_id/{id}")
    public ProductType getById(@PathVariable("id") long id){
        return productTypeRepository.findById(id);
    }

    @GetMapping("/all")
    public List<ProductType> getAll(){return productTypeRepository.findAll();}

    @PostMapping("/update")
    public void updateAuthor(@RequestBody ProductType productType){
        productTypeRepository.save(productType);
    }

    @GetMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") long id){
        productTypeRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void saveAuthor(@RequestBody ProductType productType){
        productTypeRepository.save(productType);
    }
}
