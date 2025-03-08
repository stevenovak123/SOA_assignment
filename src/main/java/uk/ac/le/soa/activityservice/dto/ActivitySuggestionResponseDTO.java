package uk.ac.le.soa.activityservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
@Schema(description = "Represents a response for activity suggestions")
public class ActivitySuggestionResponseDTO {
    @Schema(description = "Name of the city", example = "Leicester")
        private String cityName;
    @Schema(description = "Description of the weather", example = "overcast clouds")
        private String weatherDescription;
    @Schema(description = "Temperature in Celsius", example = "10.19")
        private double temperature;
    @Schema(description = "Visibility in meters", example = "10000")
        private int visibility;
    @Schema(description = "Total number of activities", example = "6")
        private int numberOfActivities;
    @Schema(description = "List of outdoor activities")
        private List<String> outdoorActivities;
    @Schema(description = "List of indoor activities")
        private List<String> indoorActivities;
    @Schema(description = "Details about the route to the closest activity")
        private RouteDetails routeDetails;
    @Schema (description = "Message that would be used by the frontend to display to the user")
    private StringBuilder message;

    public StringBuilder getMessage() {
        return message;
    }

    public void setMessage(StringBuilder message) {
        this.message=message;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getNumberOfActivities() {
        return numberOfActivities;
    }

    public void setNumberOfActivities(int numberOfActivities) {
        this.numberOfActivities = numberOfActivities;
    }

    public List<String> getOutdoorActivities() {
        return outdoorActivities;
    }

    public void setOutdoorActivities(List<String> outdoorActivities) {
        this.outdoorActivities = outdoorActivities;
    }

    public List<String> getIndoorActivities() {
        return indoorActivities;
    }

    public void setIndoorActivities(List<String> indoorActivities) {
        this.indoorActivities = indoorActivities;
    }

    public RouteDetails getRouteDetails() {
        return routeDetails;
    }

    public void setRouteDetails(RouteDetails routeDetails) {
        this.routeDetails = routeDetails;
    }



    public static class RouteDetails {
        private int durationInMinutes;
        private double distanceInMiles;
        private String modeOfTransport;

        public double getDistanceInMiles() {
            return distanceInMiles;
        }

        public void setDistanceInMiles(double distanceInMiles) {
            this.distanceInMiles = distanceInMiles;
        }

        public int getDurationInMinutes() {
            return durationInMinutes;
        }

        public void setDurationInMinutes(int durationInMinutes) {
            this.durationInMinutes = durationInMinutes;
        }

        public String getModeOfTransport() {
            return modeOfTransport;
        }

        public void setModeOfTransport(String modeOfTransport) {
            this.modeOfTransport = modeOfTransport;
        }
    }
}



