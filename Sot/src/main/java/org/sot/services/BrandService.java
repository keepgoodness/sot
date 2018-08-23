/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
