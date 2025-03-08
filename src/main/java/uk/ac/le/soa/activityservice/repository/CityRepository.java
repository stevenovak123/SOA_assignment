package uk.ac.le.soa.activityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.le.soa.activityservice.entity.City;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City,Integer> {
    Optional<City> findByCityIgnoreCase(String city);
}
