/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.repositories;

import org.sot.models.Entity.ControlBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jordan
 */
@Repository
public interface ControlBoardRepository extends JpaRepository<ControlBoard, Long> {

	public ControlBoard save(ControlBoard controlBoard);

	public void deleteById(Long id);

}
