/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.converters;

import org.modelmapper.Converter;
import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.MappingContext;
import org.sot.enums.SseStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 *
 * @author Jordan
 */
@Component
public class BooleanConverter implements Converter<String, Boolean> {

	@Override
	public Boolean convert(MappingContext<String, Boolean> context) {
		String strSource = context.getSource();
		if (strSource.toUpperCase().equals(SseStatus.FREE)) {
			return false;
		}
		if (strSource.toUpperCase().equals(SseStatus.PAID)) {
			return true;
		}
		return null;
	}
}
