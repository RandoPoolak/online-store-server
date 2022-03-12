package com.sda.onlinestoreserver.exceptions;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException(Long id) {
        super("Category (id = " + id + ") not found!");
    }

}
