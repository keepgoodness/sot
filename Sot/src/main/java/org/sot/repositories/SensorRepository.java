package org.sot.repositories;

import java.util.List;
import org.sot.enums.SensorType;
import org.sot.models.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jordan
 */
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

	@Query("select s from #{#entityName} s where s.brand.id = ?1")
	public List<Sensor> findAllByBrandId(Long id);

	@Query("select s from #{#entityName} s where s.type=?1 AND s.brand.id = ?2")
	public List<Sensor> findAllByBrandIdAndType(SensorType type, Long brandId);
}
