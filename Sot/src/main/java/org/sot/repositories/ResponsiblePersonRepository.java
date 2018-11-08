/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.repositories;

import org.sot.models.entities.ResponsiblePerson;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jordan
 */
public interface ResponsiblePersonRepository extends JpaRepository<ResponsiblePerson, Long>{
	
	public ResponsiblePerson save(ResponsiblePerson person);
//	public ResponsiblePerson findOneById(Long id);

}
