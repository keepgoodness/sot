/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.repositories;

import java.util.List;
import org.sot.models.entities.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jordan
 */
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long>{
	
	public PhoneNumber save(PhoneNumber phoneNumber);
	public List<PhoneNumber> findAll();
}
