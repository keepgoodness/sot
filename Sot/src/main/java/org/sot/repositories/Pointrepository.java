/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.repositories;

import org.sot.models.Entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jordan
 */
@Repository
public interface Pointrepository extends JpaRepository<Point, Long>{

	public Point save(Point point);
}
