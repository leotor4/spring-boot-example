package com.duvan.rest_api.mapper;

import com.duvan.rest_api.dto.CityWeatherResponseDTO;
import com.duvan.rest_api.model.entity.WeatherEntity;

public class WeatherMapper {

	public static CityWeatherResponseDTO toDto(WeatherEntity cache) {
		return new CityWeatherResponseDTO(cache.getCity(), cache.getTemperature());
	}

}
