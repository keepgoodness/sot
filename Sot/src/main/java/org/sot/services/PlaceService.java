package org.sot.services;

import java.util.List;
import org.sot.models.Entity.Place;

/**
 *
 * @author Jordan
 */
public interface PlaceService {
	
	public boolean register(String name);

	public List<Place> findAllPlaces();

	public boolean delete(Long id);
}
