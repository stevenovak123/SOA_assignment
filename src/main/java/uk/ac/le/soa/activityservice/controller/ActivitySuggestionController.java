package uk.ac.le.soa.activityservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.le.soa.activityservice.dto.ActivitySuggestionResponseDTO;
import uk.ac.le.soa.activityservice.exceptions.ActivitySuggestionException;
import uk.ac.le.soa.activityservice.exceptions.CityNotFoundException;
import uk.ac.le.soa.activityservice.exceptions.WeatherDataNotFoundException;
import uk.ac.le.soa.activityservice.service.ActivitySuggestionService;

@RestController
@RequestMapping("/suggest")
public class ActivitySuggestionController {

    @Autowired
    private ActivitySuggestionService activitySuggestionService;

    @Operation(summary = "Get activity suggestions for a given city",
            description = "Returns a list of indoor and outdoor activities based on the city's weather conditions.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved activity suggestions",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ActivitySuggestionResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "City not found or weather data unavailable",content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "503", description = "External weather service unavailable",content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))

    })
    @GetMapping("/{cityName}")
    public ResponseEntity<ActivitySuggestionResponseDTO> getActivitySuggestion(@PathVariable String cityName) {
        ActivitySuggestionResponseDTO response = activitySuggestionService.getActivitySuggestion(cityName);
        return ResponseEntity.ok(response);
    }
}
