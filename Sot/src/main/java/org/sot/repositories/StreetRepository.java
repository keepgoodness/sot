package org.sot.repositories;

import java.util.List;
import org.sot.enums.LifeStatus;
import org.sot.models.entities.Street;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jordan
 */
public interface StreetRepository extends JpaRepository<Street, Long> {

	public Street findOneById(Long id);
	
        public Street findOneByName(String name);
        
	public List<Street> findByName(String name);
        
	public List<Street> findAllByStatus(LifeStatus status);
	
	public Street save(Street street);

	public void deleteById(Long id);
}
