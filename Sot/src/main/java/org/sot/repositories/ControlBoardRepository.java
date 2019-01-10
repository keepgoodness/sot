package org.sot.repositories;

import java.util.Optional;
import org.sot.models.entities.ControlBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jordan
 */
@Repository
public interface ControlBoardRepository extends JpaRepository<ControlBoard, Long> {

	public Optional<ControlBoard> findByBrandId(Long id);
}
