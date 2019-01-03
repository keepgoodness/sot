package org.sot.repositories;

import org.sot.models.entities.ControlBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jordan
 */
@Repository
public interface ControlBoardRepository extends JpaRepository<ControlBoard, Long> {

}
