package com.sda.onlinestoreserver.exceptions;

public class LocationDataNotFoundException extends RuntimeException{
    public LocationDataNotFoundException(String params) {
        super("Location response not found for request params: " + params);
    }
}
