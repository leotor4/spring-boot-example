package com.duvan.rest_api.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherMainDTO {
	private double temp;
	private double feels_like;
	private double temp_min;
	private double temp_max;
	private int pressure;
	private int humidity;

}
