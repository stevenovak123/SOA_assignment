package uk.ac.le.soa.activityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.le.soa.activityservice.entity.City;
import uk.ac.le.soa.activityservice.exceptions.CityNotFoundException;
import uk.ac.le.soa.activityservice.repository.CityRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public Map<String, Double> getLatLong(String cityName) {
        Optional<City> city = cityRepository.findByCityIgnoreCase(cityName);

        if (city.isEmpty()) {
            throw new CityNotFoundException("City not found: ");
        }
        Map<String, Double> latLongMap = new HashMap<>();
        latLongMap.put("latitude", city.get().getLatitude());
        latLongMap.put("longitude", city.get().getLongitude());
        return latLongMap;
    }

}