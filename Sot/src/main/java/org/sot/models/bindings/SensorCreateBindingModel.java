package org.sot.models.bindings;

import javax.validation.constraints.Size;
import javax.xml.ws.BindingType;

/**
 *
 * @author Jordan
 */

public class SensorCreateBindingModel {

    private String sensorId;
    private String sensorType;
    private String sensorBrandId;
    @Size(max = 20, message = "Модела не може да надвишава 20 символа")
    private String sensorModel;
    @Size(max = 10, message = "Кода не може да надвишава 10 символа")
    private String sensorCode;
    private String sensorPrice;

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorBrandId() {
        return sensorBrandId;
    }

    public void setSensorBrandId(String sensorBrandId) {
        this.sensorBrandId = sensorBrandId;
    }

    public String getSensorModel() {
        return sensorModel;
    }

    public void setSensorModel(String sensorModel) {
        this.sensorModel = sensorModel;
    }

    public String getSensorCode() {
        return sensorCode;
    }

    public void setSensorCode(String sensorCode) {
        this.sensorCode = sensorCode;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getSensorPrice() {
        return sensorPrice;
    }

    public void setSensorPrice(String sensorPrice) {
        this.sensorPrice = sensorPrice;
    }

}
