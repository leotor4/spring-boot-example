package com.duvan.rest_api.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WeatherEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String city;
	
	private Double temperature;
	
	private LocalDateTime createdAt;

}
