package com.sda.onlinestoreserver.services;

import com.sda.onlinestoreserver.services.implementations.models.weatherResponse.WeatherResponse;

public interface WeatherService {

    WeatherResponse getWeatherData(Double lon, Double lat);

    WeatherResponse requestWeather(String city);
}
