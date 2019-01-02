package org.sot.services;

import java.util.List;
import java.util.Optional;
import org.sot.models.bindings.BrandBindingModel;
import org.sot.models.entities.Brand;
import org.sot.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jordan
 */
@Service
public class BrandServiceImpl implements BrandService {

	private final BrandRepository brandRepository;

	@Autowired
	public BrandServiceImpl(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public boolean register(BrandBindingModel bindingModel) {
		String nameNormalize = normalize(bindingModel.getName());
		Brand fb = this.brandRepository.findFirstByName(nameNormalize);
		if (fb != null) {
			return false;
		}
		Brand brand = new Brand();
		brand.setName(nameNormalize);
		Brand b = this.brandRepository.save(brand);
		if (b == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<Brand> findAllBrands() {
		this.brandRepository.findAll().forEach(b -> b.setName(capitalize(b.getName())));
		return this.brandRepository.findAll();
	}

	public static String capitalize(String x) {
		return x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
	}

	public String normalize(String x) {
		return x.toLowerCase();
	}

	@Override
	public boolean delete(String idString) {
		Long id = Long.parseLong(idString);
		this.brandRepository.deleteById(id);
		if (this.brandRepository.findById(id).isPresent()) {
			return false;
		}
		return true;
	}

}
