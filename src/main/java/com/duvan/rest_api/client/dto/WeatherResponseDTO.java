package com.duvan.rest_api.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherResponseDTO {
	private WeatherMainDTO main;
	private String name;
}
