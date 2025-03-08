package uk.ac.le.soa.activityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uk.ac.le.soa.activityservice.entity.RouteData;

@Repository
public interface RouteDataRepository extends JpaRepository<RouteData,Integer> {
    @Query(value = "SELECT * FROM route_data ORDER BY RAND() LIMIT 1", nativeQuery = true)
    RouteData findRandomRouteData();
}
