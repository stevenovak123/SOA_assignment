package uk.ac.le.soa.activityservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import uk.ac.le.soa.activityservice.dto.WeatherResponseDTO;
import uk.ac.le.soa.activityservice.entity.Weather;
import uk.ac.le.soa.activityservice.exceptions.WeatherDataNotFoundException;
import uk.ac.le.soa.activityservice.exceptions.WeatherServiceException;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${weatherServiceApiKey}")
    private String weatherServiceApiKey;

    public Weather fetchWeather(double lat, double lon) {

        String url = String.format(
                "https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&units=metric&appid=%s",
                lat, lon, weatherServiceApiKey
        );

        try {
            WeatherResponseDTO response = restTemplate.getForObject(url, WeatherResponseDTO.class);

            if (response == null || response.getCoord() == null || response.getWeather() == null || response.getWeather().length == 0) {
                throw new WeatherDataNotFoundException("Weather data not available for the given coordinates.");
            }

            return new Weather(
                    response.getCoord().getLon(),
                    response.getCoord().getLat(),
                    response.getWeather()[0].getDescription(),
                    response.getVisibility(),
                    response.getMain().getTemp()
            );

        } catch (HttpClientErrorException.NotFound e) {
            throw new WeatherDataNotFoundException("Weather data not found for the given coordinates.");
        } catch (RestClientException e) {
            throw new WeatherServiceException("Error fetching weather data.", e);
        }
    }
}

