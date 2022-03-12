package com.sda.onlinestoreserver.exceptions;

public class OrderNotFoundException extends Exception{
    public OrderNotFoundException(Long id) {
        super("Order(id = " + id + ") not found!");
    }
}
