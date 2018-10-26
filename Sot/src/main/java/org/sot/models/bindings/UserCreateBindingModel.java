package org.sot.models.bindings;

import java.util.List;
import org.sot.models.entities.user.Role;

/**
 *
 * @author Jordan
 */
public class UserCreateBindingModel {
	
	private String username;
	private String password;
	private String role;
	private List<Role> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
