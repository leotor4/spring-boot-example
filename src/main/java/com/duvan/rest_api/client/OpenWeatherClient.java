package com.duvan.rest_api.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.duvan.rest_api.client.dto.GeoCodingResponseDTO;
import com.duvan.rest_api.client.dto.WeatherResponseDTO;

@Component
public class OpenWeatherClient {

	@Value("${openweathermap.api-key}")
	private String apiKey;

	@Value("${openweathermap.geo-url}")
	private String geoUrl;

	@Value("${openweathermap.weather-url}")
	private String weatherUrl;

	private final RestTemplate restTemplate = new RestTemplate();

	public Optional<double[]> getLatLon(String city) {
		String url = String.format("%s?q=%s&limit=1&appid=%s", geoUrl, city, apiKey);
		ResponseEntity<List<GeoCodingResponseDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<>() {
				});
		if (response.getBody() == null || response.getBody().isEmpty())
			return Optional.empty();
		GeoCodingResponseDTO loc = response.getBody().get(0);
		return Optional.of(new double[] { (Double) loc.getLat(), (Double) loc.getLon() });
	}

	public Optional<Double> getTemperature(double lat, double lon) {
		String url = String.format("%s?lat=%s&lon=%s&appid=%s&units=metric", weatherUrl, lat, lon, apiKey);

		WeatherResponseDTO response = restTemplate.getForObject(url, WeatherResponseDTO.class);

		if (response == null || response.getMain() == null) {
			return Optional.empty();
		}

		return Optional.of(response.getMain().getTemp());
	}
}
