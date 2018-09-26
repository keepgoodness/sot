package org.sot.services;

import java.util.List;
import java.util.Optional;
import org.sot.models.entities.Place;
import org.sot.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jordan
 */
@Service
@Primary
public class PlaceServiceImp implements PlaceService {

	private final PlaceRepository placeRepository;

	@Autowired
	public PlaceServiceImp(PlaceRepository placeRepository) {
		this.placeRepository = placeRepository;
	}

	@Override
	public boolean register(String name) {
		Place rPl = this.placeRepository.findFirstByName(name);
		if (rPl != null) {
			return false;
		}
		Place place = new Place();
		place.setName(name);
		Place sPl = this.placeRepository.save(place);
		if (sPl == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<Place> findAllPlaces() {
		this.placeRepository.findAll().forEach(pl -> pl.setName(capitalize(pl.getName())));
		return this.placeRepository.findAll();
	}

	public static String capitalize(String x) {
		return x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
	}

	@Override
	public boolean delete(Long id) {
		this.placeRepository.deleteById(id);
		Optional<Place> place = this.placeRepository.findById(id);
		if (place.isPresent()) {
			return false;
		}
		return true;
	}

}
