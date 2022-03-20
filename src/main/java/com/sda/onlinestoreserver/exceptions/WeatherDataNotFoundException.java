package com.sda.onlinestoreserver.exceptions;


public class WeatherDataNotFoundException extends RuntimeException {
    public WeatherDataNotFoundException(String params) {
        super("Weather response not found for request params: " + params);
    }
}
