/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.services;

import org.sot.models.Entity.Address;
import org.sot.models.Entity.Point;
import org.sot.models.requests.PointRequestModel;
import org.sot.repositories.AddressRepository;
import org.sot.repositories.Pointrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jordan
 */
@Service
public class PointService {

	private final AddressRepository addressRepository;
	private final Pointrepository pointrepository;

	public PointService(AddressRepository addressRepository, Pointrepository pointrepository) {
		this.addressRepository = addressRepository;
		this.pointrepository = pointrepository;
	}

	@Transactional
	public boolean register(PointRequestModel prm) {
		Address address = prm.getAddress();
		Point point = new Point();
		point.setName(prm.getPointName());
		point.setIdentifier(prm.getPointIdentifier());
		point.setPlace(prm.getPlace());
		point.setAddress(address);
		addressRepository.save(address).getId();
		Long id = pointrepository.save(point).getId();
		if (id == null) {
			return false;
		}
		return true;
	}

}
