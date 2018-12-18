package org.sot.converters;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sot.enums.VatStatus;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jordan
 */
@Component
public class VatStatusConverter implements Converter<String, Boolean> {

	@Override
	public Boolean convert(MappingContext<String, Boolean> context) {
		String strSource = context.getSource();
		if (strSource.toUpperCase().equals(VatStatus.NO)) {
			return false;
		}
		if (strSource.toUpperCase().equals(VatStatus.YES)) {
			return true;
		}
		return null;
	}

}
