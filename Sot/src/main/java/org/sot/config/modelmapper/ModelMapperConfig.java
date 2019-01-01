package org.sot.config.modelmapper;

import org.modelmapper.ModelMapper;
import org.sot.models.bindings.PointAtrBindingModel;
import org.sot.models.bindings.SensorCreateBindingModel;
import org.sot.models.entities.Point;
import org.sot.models.entities.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jordan
 */
@Component
public class ModelMapperConfig {

    private final PointRequestToPointYesOrNoCompany yesOrNoCompany;

    @Autowired
    public ModelMapperConfig(PointRequestToPointYesOrNoCompany yesOrNoCompany) {
        this.yesOrNoCompany = yesOrNoCompany;
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        if (modelMapper.getTypeMap(PointAtrBindingModel.class, Point.class) == null) {
          modelMapper.addMappings(this.yesOrNoCompany);
        }
        return modelMapper;
    }
}
