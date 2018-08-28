package org.sot.repositories;

import java.util.List;
import java.util.Optional;
import javax.persistence.Id;
import org.sot.models.Entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jordan
 */
public interface PlaceRepository extends JpaRepository<Place, Long> {

	public Place findFirstByName(String name);

	public List<Place> findAll();

	public Place save(Place place);

	public void deleteById(Long id);
}
