package com.duvan.rest_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duvan.rest_api.dto.CityWeatherResponseDTO;
import com.duvan.rest_api.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<CityWeatherResponseDTO> getWeather(@PathVariable String city) {
    	  CityWeatherResponseDTO result = weatherService.getWeatherForCity(city);
          return ResponseEntity.ok(result);
    }
}
