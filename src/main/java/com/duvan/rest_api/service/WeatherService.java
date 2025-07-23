package com.duvan.rest_api.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duvan.rest_api.client.OpenWeatherClient;
import com.duvan.rest_api.dto.CityWeatherResponseDTO;
import com.duvan.rest_api.exception.CityNotFoundException;
import com.duvan.rest_api.exception.WeatherUnavailableException;
import com.duvan.rest_api.mapper.WeatherMapper;
import com.duvan.rest_api.model.entity.WeatherEntity;
import com.duvan.rest_api.repository.WeatherRepository;

@Service
public class WeatherService {
	
	  private final WeatherRepository repository;
	    private final OpenWeatherClient client;

	    public WeatherService(WeatherRepository repository, OpenWeatherClient client) {
	        this.repository = repository;
	        this.client = client;
	    }

	    public CityWeatherResponseDTO getWeatherForCity(String city) {
	        Optional<WeatherEntity> cached = repository.findTopByCityOrderByCreatedAtDesc(city);
	        
	        if (cached.isPresent() && cached.get().getCreatedAt().isAfter(LocalDateTime.now().minusMinutes(15))) {
	            return WeatherMapper.toDto(cached.get());
	        }

	        var latLon = client.getLatLon(city).orElseThrow(() -> new CityNotFoundException(city));
	        var temp = client.getTemperature(latLon[0], latLon[1]).orElseThrow(() -> new WeatherUnavailableException(city));

	        WeatherEntity saved = repository.save(new WeatherEntity(null, city, temp, LocalDateTime.now()));
	        return WeatherMapper.toDto(saved);
	    }

}
