package org.sot.repositories;

import java.util.List;
import org.sot.models.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jordan
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

	public Brand findFirstByName(String name);

	public List<Brand> findAll();

	public Brand save(Brand brand);

	public void deleteById(Long id);

}
