/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.repositories;

import java.util.List;
import org.sot.models.Entity.Place;
import org.sot.models.Entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jordan
 */
@Repository
public interface Pointrepository extends JpaRepository<Point, Long>{

	public List<Point> findAll();
	public Point findPointById(Long id);
	public Point save(Point point);
	public void deleteById(Long id);
}
