/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.repositories;

import java.util.List;
import java.util.Optional;
import org.sot.models.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jordan
 */
public interface BrandRepository extends JpaRepository<Brand, Long> {

	public Brand findFirstByName(String name);

	public List<Brand> findAll();

	public Brand save(Brand brand);

//	public Optional<Brand> findById(Long id);

	public void deleteById(Long id);

}
