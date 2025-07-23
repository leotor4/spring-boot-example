package com.duvan.rest_api.exception;

public class CityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -7866528181078636328L;

	public CityNotFoundException(String city) {
		super("City not found: " + city);
	}
}
