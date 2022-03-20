package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.services.implementations.models.weatherResponse.WeatherResponse;
import com.sda.onlinestoreserver.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/weather")
public class WeatherApiController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherResponse weatherData(@PathVariable("city") String city) {
        return weatherService.requestWeather(city);
    }
}
