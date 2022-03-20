package com.sda.onlinestoreserver.services.implementations;

import com.sda.onlinestoreserver.exceptions.LocationDataNotFoundException;
import com.sda.onlinestoreserver.exceptions.WeatherDataNotFoundException;
import com.sda.onlinestoreserver.services.implementations.models.locationResponse.LocationResponse;
import com.sda.onlinestoreserver.services.implementations.models.weatherResponse.WeatherResponse;
import com.sda.onlinestoreserver.repository.ApiRepository;
import com.sda.onlinestoreserver.services.WeatherService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class WeatherServiceImpl implements WeatherService {
    private static final String WEATHER_IDENTIFIER = "weather";

    @Autowired
    private ApiRepository apiRepository;

    @Value("${app.api.external.weather}")
    private String weatherApiBaseUrl;

    @Value("${app.api.external.location}")
    private String locationApiBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getWeatherData(Double lon, Double lat) {
        String queryParams = "?lat=" + lat + "&lon=" + lon + "&appid=" + apiRepository.findByIdentifier(WEATHER_IDENTIFIER).getApiKey();
        ResponseEntity<WeatherResponse> weatherResponse = restTemplate.getForEntity(weatherApiBaseUrl.concat(queryParams), WeatherResponse.class);

        if(!weatherResponse.getStatusCode().is2xxSuccessful() || weatherResponse.getBody() == null) {
            throw new WeatherDataNotFoundException(StringUtils.substring(queryParams, 1));
        }

        return weatherResponse.getBody();
    }

    @Override
    public WeatherResponse requestWeather(String city){
        String queryParams = "?q=" + city + "&limit=1&appid=" + apiRepository.findByIdentifier(WEATHER_IDENTIFIER).getApiKey();
        ResponseEntity<LocationResponse[]> locationResponse = restTemplate.getForEntity(locationApiBaseUrl.concat(queryParams), LocationResponse[].class);
        if(!locationResponse.getStatusCode().is2xxSuccessful() || locationResponse.getBody() == null) {
            throw new LocationDataNotFoundException(StringUtils.substring(queryParams, 1));
        }
        return getWeatherData(locationResponse.getBody()[0].getLon(), locationResponse.getBody()[0].getLat());
    }

}
