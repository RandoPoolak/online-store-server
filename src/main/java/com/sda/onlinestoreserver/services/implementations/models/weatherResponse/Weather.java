package com.sda.onlinestoreserver.services.implementations.models.weatherResponse;

import lombok.Data;


@Data
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
