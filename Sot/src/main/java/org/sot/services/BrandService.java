package org.sot.services;

import java.util.List;
import org.sot.models.bindings.BrandBindingModel;
import org.sot.models.entities.Brand;

/**
 *
 * @author Jordan
 */
public interface BrandService {

	public boolean register(BrandBindingModel bindingModel);

	public List<Brand> findAllBrands();

	public boolean delete(String id);

}
