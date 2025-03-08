package uk.ac.le.soa.activityservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ActivitySuggestionException extends RuntimeException {
    public ActivitySuggestionException(String message) {
        super(message);
    }
}