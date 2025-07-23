package com.duvan.rest_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duvan.rest_api.model.entity.WeatherEntity;

public interface WeatherRepository extends JpaRepository<WeatherEntity, String>  {
	
	Optional<WeatherEntity> findTopByCityOrderByCreatedAtDesc(String city);

}
