package org.sot.services;

import java.util.List;
import org.sot.models.Entity.Brand;

/**
 *
 * @author Jordan
 */
public interface BrandService {

	public boolean register(String name);

	public List<Brand> findAllBrands();

	public boolean delete(Long id);

}
