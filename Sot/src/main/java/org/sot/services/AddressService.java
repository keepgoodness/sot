/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.services;

import org.sot.models.Entity.Address;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jordan
 */
public interface AddressService {
	public boolean create(Address address);
}
