# Weather API

A simple REST API built with Spring Boot to fetch weather data based on city names. The application handles errors gracefully with custom exceptions and standardized error responses.
Features

    Retrieve weather data by city name

    Custom exceptions:

        CityNotFoundException

        WeatherUnavailableException

    Global exception handler with structured error response

    DTOs for both data and error payloads

Technologies

    Java 17+

    Spring Boot

    Spring Web

    OpenWeatherMap API (or other weather providers)

    Maven or Gradle

Project Structure

    controller: REST API endpoints

    service: Business logic for fetching weather data

    exception: Custom exception classes and global handler

    dto: Data Transfer Objects for requests/responses

Getting Started

    Clone the repository

    git clone https://github.com/yourusername/weather-api.git

    Navigate to the project directory

    cd weather-api

    Configure your API key

    Set your OpenWeatherMap API key in application.properties or as an environment variable.

    Run the application

    ./mvnw spring-boot:run

Example Usage

GET /weather/fortaleza

Response:

{
"city": "fortaleza",
"temperature": 22.4
}

Error Response:

{
"timestamp": "2025-07-23T22:30:01.421",
"status": 400,
"error": "Bad Request",
"message": "City not found: xyz"
}
License

MIT License
