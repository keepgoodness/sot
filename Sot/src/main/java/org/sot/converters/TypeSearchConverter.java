package org.sot.converters;

import java.beans.PropertyEditorSupport;
import org.sot.enums.TypeSearch;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Jordan
 */
@Configuration
public class TypeSearchConverter extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String capitalized = text.toUpperCase();
		TypeSearch typeSearch = TypeSearch.valueOf(capitalized);
		setValue(typeSearch);
	}
	
}
