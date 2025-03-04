package uk.ac.le.soa.activityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.le.soa.activityservice.entity.Hello;

@Repository
public interface HelloRepository extends JpaRepository<Hello, Integer> {

}
