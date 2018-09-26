package org.sot.models.requests;

import javax.validation.constraints.Size;

/**
 *
 * @author Jordan
 */
public class PlaceCreateBindingModel {
	
	@Size(max = 30, min = 1, message = "Населеното място e между 1 и 30 символа!")
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
