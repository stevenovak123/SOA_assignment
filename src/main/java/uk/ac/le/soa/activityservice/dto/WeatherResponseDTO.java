package uk.ac.le.soa.activityservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



public class WeatherResponseDTO {

    @JsonProperty("coord")
    private Coord coord;

    @JsonProperty("weather")
    private Weather[] weather;

    @JsonProperty("visibility")
    private int visibility;

    @JsonProperty("main")
    private Main main;

    // Getters
    public Coord getCoord() {
        return coord;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public int getVisibility() {
        return visibility;
    }
    public Main getMain() {
        return main;
    }


    public static class Coord {
        private double lon;
        private double lat;

        // Getters
        public double getLon() {
            return lon;
        }

        public double getLat() {
            return lat;
        }
    }

    public static class Weather {
        private String description;

        // Getter
        public String getDescription() {
            return description;
        }
    }

    public static class Main {
        private double temp; //

        // Getter
        public double getTemp() {
            return temp;
        }
    }
}