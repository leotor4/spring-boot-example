package com.duvan.rest_api.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
}
