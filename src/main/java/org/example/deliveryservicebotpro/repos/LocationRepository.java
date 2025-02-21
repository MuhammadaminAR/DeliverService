package org.example.deliveryservicebotpro.repos;

import org.example.deliveryservicebotpro.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}