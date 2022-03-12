package com.sda.onlinestoreserver.exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(Long id) {
        super("Product(id = " + id + ") not found!");
    }

}
