package org.sot.services.implementations;

import java.util.Set;
import java.util.stream.Collectors;
import org.sot.models.entities.user.User;
import org.sot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sot.services.interfaces.UserService;

/**
 *
 * @author Jordan
 */
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findFirstByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found!");
		}

		Set<SimpleGrantedAuthority> roles = user.getRoles().stream()
				.map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName()))
				.collect(Collectors.toSet());

		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				roles);
	}

}
