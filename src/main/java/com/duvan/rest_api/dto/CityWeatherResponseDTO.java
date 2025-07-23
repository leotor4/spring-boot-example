package com.duvan.rest_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityWeatherResponseDTO {
	private String city;
	private Double temperature;
}
