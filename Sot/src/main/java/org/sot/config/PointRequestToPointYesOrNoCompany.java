/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.config;

import org.sot.models.bindings.PointAtrBindingModel;
import org.modelmapper.Condition;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.sot.models.entities.Company;
import org.sot.models.entities.Point;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jordan
 */
@Component
public class PointRequestToPointYesOrNoCompany extends PropertyMap<PointAtrBindingModel, Point> {

	Condition<PointAtrBindingModel, Company> isNotEmpty = new Condition<PointAtrBindingModel, Company>() {
		@Override
		public boolean applies(MappingContext<PointAtrBindingModel, Company> context) {
			return !context.getSource().getCompanyBulstat().trim().isEmpty();
		}
	};

	@Override
	protected void configure() {
		when(isNotEmpty).map(source).setCompany(null);
	}

}
