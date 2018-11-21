package org.sot.repositories;

import org.sot.models.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jordan
 */
public interface CompanyRepository extends JpaRepository<Company, Long>{
    
}
