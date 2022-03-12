package com.sda.onlinestoreserver.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(Long id) {
        super("User(id = " + id + ") not found!");
    }

}
