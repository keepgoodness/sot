/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.enums;

import java.util.Arrays;

/**
 *
 * @author Jordan
 */
public enum SensorType {

    PIR("ОБЕМЕН"),
    ACUSTIC("АКУСТИЧЕН"),
    MAGNETIC("МАГНИТЕН"),
    SEISMIC("СЕИЗМИЧЕН"),
    FIRE("ПОЖАРЕН"),
    PERIMETER("ПЕРИМЕТЪР"),
    PANICBUTTON("ПАНИК БУТОН");

    private final String value;

    SensorType(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    public static SensorType[] getSortedValues() {
        SensorType[] values = SensorType.values();
        Arrays.sort(values, (s1, s2) -> s1.getValue().compareTo(s2.getValue()));
        return values;
    }
}
