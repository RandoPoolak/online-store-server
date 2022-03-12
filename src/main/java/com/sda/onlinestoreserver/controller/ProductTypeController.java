package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.exceptions.ProductTypeNotFoundException;
import com.sda.onlinestoreserver.models.ProductType;
import com.sda.onlinestoreserver.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-type")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id){
        try{
            ProductType productType = productTypeService.findById(id);
            return new ResponseEntity<>(productType, HttpStatus.FOUND);
        }catch (ProductTypeNotFoundException e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<ProductType> getAll(){return productTypeService.getAll();}

    @PostMapping("/update")
    public void updateAuthor(@RequestBody ProductType productType){
        try{
            productTypeService.updateProductType(productType);
        }catch (ProductTypeNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") long id){
        try{
            productTypeService.deleteProductTypeById(id);
        }catch (ProductTypeNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/restore/{id}")
    public void restoreAuthor(@PathVariable("id") long id){
        try{
            productTypeService.restoreProductTypeById(id);
        }catch (ProductTypeNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @PostMapping("/save")
    public void saveAuthor(@RequestBody ProductType productType){
        productTypeService.createProductType(productType);
    }
}
