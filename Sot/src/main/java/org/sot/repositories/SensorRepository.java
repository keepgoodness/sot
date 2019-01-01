package org.sot.repositories;

import org.sot.models.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jordan
 */
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long>{
    
}
