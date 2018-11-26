package org.sot.repositories;

import java.util.List;
import org.sot.models.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jordan
 */
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

        public Place findOneById(Long id);
        
	public Place findOneByName(String name);
        
        public Place findFirstByName(String name);

	public List<Place> findAll();

	public Place save(Place place);

	public void deleteById(Long id);
        
}
