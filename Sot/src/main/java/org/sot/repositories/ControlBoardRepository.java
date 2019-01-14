package org.sot.repositories;

import java.util.List;
import java.util.Optional;
import org.sot.models.entities.ControlBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jordan
 */
@Repository
public interface ControlBoardRepository extends JpaRepository<ControlBoard, Long> {

	public Optional<ControlBoard> findByBrandId(Long id);
	
	@Query("select c from #{#entityName} c where c.brand.id = ?1")
	public List<ControlBoard> findAllByBrandId(Long id);
}
