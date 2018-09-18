/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.services;

import org.sot.models.Entity.Address;
import org.sot.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jordan
 */
@Service
@Primary
public class AddressServiceImpl implements AddressService {

	private final AddressRepository addressRepository;

	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Override
	public boolean create(Address address) {
		Address a = addressRepository.save(address);
		System.out.println("save Address -  Id:" + a.getId() + ", street:" + a.getStreet());
		if (a.getId() != null) {
			return true;
		}
		return true;
	}
}
