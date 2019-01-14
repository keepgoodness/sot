package org.sot.services;

import java.util.List;
import org.sot.models.bindings.BrandBindingModel;
import org.sot.models.entities.Brand;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Jordan
 */
public interface BrandService {

	public boolean register(BrandBindingModel bindingModel);

	public List<Brand> findAllBrands();

	public ResponseEntity<String> delete(String idString);

}
