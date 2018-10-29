package org.sot.repositories;

import org.sot.models.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jordan
 */
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findFirstByUsername(String username);
}
