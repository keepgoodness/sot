package org.sot.models.bindings;

import javax.validation.constraints.Size;

/**
 *
 * @author Jordan
 */
public class UnitBinding {
	
	@Size(max = 100, min = 2, message = "Името на компонента трябва да бъде между 2 и 100 символа!")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
