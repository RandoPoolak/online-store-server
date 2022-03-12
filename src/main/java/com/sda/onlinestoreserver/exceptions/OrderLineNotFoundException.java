package com.sda.onlinestoreserver.exceptions;

public class OrderLineNotFoundException extends Exception{
    public OrderLineNotFoundException(Long id) {
        super("OrderLine (id = " + id + ") not found!");
    }

}
