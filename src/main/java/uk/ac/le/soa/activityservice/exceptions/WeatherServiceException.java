package uk.ac.le.soa.activityservice.exceptions;

public class WeatherServiceException extends RuntimeException {
    public WeatherServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
