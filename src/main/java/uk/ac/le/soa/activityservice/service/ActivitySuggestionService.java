package uk.ac.le.soa.activityservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.le.soa.activityservice.dto.ActivitySuggestionResponseDTO;
import uk.ac.le.soa.activityservice.entity.Activity;
import uk.ac.le.soa.activityservice.entity.RouteData;
import uk.ac.le.soa.activityservice.entity.Weather;
import uk.ac.le.soa.activityservice.repository.ActivityRepository;
import uk.ac.le.soa.activityservice.repository.RouteDataRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ActivitySuggestionService {
    private static final Logger logger = LoggerFactory.getLogger(ActivitySuggestionService.class);

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private CityService cityService;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private RouteDataRepository routeDataRepository;

    public ActivitySuggestionResponseDTO getActivitySuggestion(String cityName) {
        // Fetch latitude and longitude
        Map<String, Double> cityData = cityService.getLatLong(cityName);

        // Pass latitude and longitude to weather service
        double latitude = cityData.get("latitude");
        double longitude = cityData.get("longitude");

        Weather weatherData = weatherService.fetchWeather(latitude, longitude);

        // Fetch activities
        List<Activity> indoor = activityRepository.findRandomIndoorActivities();
        List<Activity> outdoor = (weatherData.getTemp() > 5 && weatherData.getVisibility() > 5000)
                ? activityRepository.findRandomOutdoorActivities()
                : new ArrayList<>();

        // Create response DTO
        ActivitySuggestionResponseDTO response = new ActivitySuggestionResponseDTO();
        response.setCityName(cityName);
        response.setWeatherDescription(weatherData.getDescription()); // Assumed field in Weather object
        response.setTemperature(weatherData.getTemp());
        response.setVisibility(weatherData.getVisibility());

        // Set activities lists
        response.setIndoorActivities(indoor.stream().map(Activity::getName).collect(Collectors.toList()));
        response.setOutdoorActivities(outdoor.stream().map(Activity::getName).collect(Collectors.toList()));
        response.setNumberOfActivities(outdoor.size() + indoor.size());
        // Set route details
        RouteData routeData = routeDataRepository.findRandomRouteData();
        ActivitySuggestionResponseDTO.RouteDetails routeDetails = new ActivitySuggestionResponseDTO.RouteDetails();
        routeDetails.setDurationInMinutes(routeData.getEstimatedTime());
        routeDetails.setDistanceInMiles(routeData.getDistance());
        routeDetails.setModeOfTransport(routeData.getRouteDescription());

        response.setRouteDetails(routeDetails);
        // Construct output
        StringBuilder output = new StringBuilder();
        output.append("In ").append(cityName).append(", the weather is ").append(weatherData.toString()).append(".\n")
                .append("There are ").append(outdoor.size() + indoor.size()).append(" activities: ")
                .append(outdoor.size()).append(" outdoor and ").append(indoor.size()).append(" indoor.\n");

        if (!outdoor.isEmpty()) {
            output.append("Outdoor activities are:\n");
            for (Activity activity : outdoor) {
                output.append("- ").append(activity.toString()).append("\n");
            }
        } else {
            output.append("No outdoor activities available due to weather conditions.\n");
        }

        if (!indoor.isEmpty()) {
            output.append("Indoor activities are:\n");
            for (Activity activity : indoor) {
                output.append("- ").append(activity.toString()).append("\n");
            }
        } else {
            output.append("No indoor activities available.\n");
        }

        output.append("The route to get to the closest activity is: ").append(routeData.toString()).append(".");
        response.setMessage(output);
        return response;
    }
}