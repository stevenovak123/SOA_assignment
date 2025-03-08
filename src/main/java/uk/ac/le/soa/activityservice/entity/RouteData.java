package uk.ac.le.soa.activityservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RouteData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int estimatedTime;
    private double distance;
    private String routeDescription;

    public RouteData() {
    }

    public RouteData(int estimatedTime, double distance, String routeDescription) {
        this.estimatedTime = estimatedTime;
        this.distance = distance;
        this.routeDescription = routeDescription;
    }

    @Override
    public String toString() {
        return   estimatedTime + " minutes, " +
                 + distance + " miles away by "
                 + routeDescription ;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getRouteDescription() {
        return routeDescription;
    }

    public void setRouteDescription(String routeDescription) {
        this.routeDescription = routeDescription;
    }



}
