package com.duvan.rest_api.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeoCodingResponseDTO {
	private String name;
    private double lat;
    private double lon;
    private String country;
    private String state;

}
