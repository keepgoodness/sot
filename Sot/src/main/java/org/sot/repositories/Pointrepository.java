/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.repositories;

import java.util.List;
import org.sot.models.entities.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jordan
 */
@Repository
public interface Pointrepository extends JpaRepository<Point, Long>{

	public List<Point> findAll();
	
	@Query(value = "select p.id, p.lat, p.lng, p.name from Point p")
	public List<Object[]> findAllWithIdLatLng();
	
	public Point findPointById(Long id);
	public Point save(Point point);
	public void deleteById(Long id);
	
	@Query(value = "select p.id, p.name from Point p where p.name like %?1%")
	public List<Object[]> findByName(String name);
}
