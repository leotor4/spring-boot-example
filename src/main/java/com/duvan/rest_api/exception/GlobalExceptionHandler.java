package com.duvan.rest_api.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(WeatherUnavailableException.class)
	public ResponseEntity<ErrorResponseDTO> handleWeatherUnavailable(WeatherUnavailableException ex) {
		 return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCityNotFound(CityNotFoundException ex) {
		return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Optional: handle any uncaught exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleOtherErrors(Exception ex) {
    	return buildResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private ResponseEntity<ErrorResponseDTO> buildResponse(String message, HttpStatus status) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message
        );
        return new ResponseEntity<>(error, status);
    }
}
