package com.sda.onlinestoreserver.services.implementations.models.locationResponse;

import lombok.Data;

import java.util.Map;

@Data
public class LocationResponse {
    private String name;
    private Map<String,String> local_names;
    private double lat;
    private double lon;
    private String country;
    private String state;
}
