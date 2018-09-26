package org.sot.models.bindings;

import javax.validation.constraints.Size;

/**
 *
 * @author Jordan
 */
public class BrandBindingModel {
    
	@Size(max = 25, min = 2, message = "Името на марката трябва да бъде между 2 и 25 символа!")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
