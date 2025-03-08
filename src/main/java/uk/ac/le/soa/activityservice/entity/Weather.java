package uk.ac.le.soa.activityservice.entity;


public class Weather {
    private double lon;
    private double lat;
    private String description;
    private int visibility;  // visibility in meters
    private double temp;

    public Weather(double lon, double lat, String description, int visibility, double temp) {
        this.lon = lon;
        this.lat = lat;
        this.description = description;
        this.visibility = visibility;
        this.temp =temp;
    }


    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public String getDescription() {
        return description;
    }

    public int getVisibility() {
        return visibility;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return description +
                " and the temperature is " + temp + " degrees Celsius " +
                "with a visibility of " + visibility + " meters";
    }
    }
