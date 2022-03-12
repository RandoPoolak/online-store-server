package com.sda.onlinestoreserver.exceptions;

public class ProductTypeNotFoundException extends Exception{
    public ProductTypeNotFoundException(Long id) {
        super("ProductType(id = " + id + ") not found!");
    }

}
