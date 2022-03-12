package com.sda.onlinestoreserver.exceptions;

public class AddressNotFoundException extends Exception{
    public AddressNotFoundException(Long id) {
        super("Address (id = " + id + ") not found!");
    }

}
