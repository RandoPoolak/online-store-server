package com.sda.onlinestoreserver.services.implementations.models.weatherResponse;


import lombok.Data;

import java.util.ArrayList;

@Data
public class WeatherResponse {
    private Coord coord;
    private ArrayList<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private int dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

}
