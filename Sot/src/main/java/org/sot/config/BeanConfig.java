package org.sot.config;

import org.sot.config.modelmapper.PointRequestToPointYesOrNoCompany;
import org.sot.models.bindings.PointAtrBindingModel;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.sot.models.entities.Company;
import org.sot.models.entities.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jordan
 */
@Component
public class BeanConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
