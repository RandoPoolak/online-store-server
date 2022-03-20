package com.sda.onlinestoreserver.services.implementations.models.weatherResponse;

import lombok.Data;


@Data
public class Sys {
    private int type;
    private int id;
    private double message;
    private String country;
    private int sunrise;
    private int sunset;
}
