package com.sda.onlinestoreserver.exceptions;

public class AuthorNotFoundException extends Exception{
    public AuthorNotFoundException(Long id) {
        super("Author(id = " + id + ") not found!");
    }

}
