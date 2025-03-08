package uk.ac.le.soa.activityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uk.ac.le.soa.activityservice.entity.Activity;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    // For indoor activities
    @Query(value = "SELECT * FROM Activity WHERE type = 'indoor' ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Activity> findRandomIndoorActivities();

    // For outdoor activities
    @Query(value = "SELECT * FROM Activity WHERE type = 'outdoor' ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Activity> findRandomOutdoorActivities();
}
