/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.services;

import java.util.List;
import java.util.Optional;
import org.sot.models.Entity.Brand;
import org.sot.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jordan
 */
@Service
@Primary
public class BrandServiceImpl implements BrandService {

	private final BrandRepository brandRepository;

	@Autowired
	public BrandServiceImpl(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public boolean register(String name) {

		Brand fb = this.brandRepository.findFirstByName(name);
		if (fb != null) {
			return false;
		}
		Brand brand = new Brand();
		brand.setName(name);
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

	@Override
	public boolean delete(Long id) {
		System.out.println(id);
		this.brandRepository.deleteById(id);
		Optional<Brand> b = this.brandRepository.findById(id);
		if (b.isPresent()) {
			return false;
		}
		return true;
	}

}
