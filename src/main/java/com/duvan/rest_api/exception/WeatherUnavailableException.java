package com.duvan.rest_api.exception;

public class WeatherUnavailableException extends RuntimeException {

	private static final long serialVersionUID = 5621188789939629399L;

	public WeatherUnavailableException(String city) {
		super("Weather data unavailable for city: " + city);
	}

}
