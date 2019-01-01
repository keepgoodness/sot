///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.sot.converters;
//
//import org.modelmapper.Converter;
//import org.modelmapper.spi.MappingContext;
//import org.sot.enums.SensorType;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author Jordan
// */
//@Component
//public class SensorTypeConverter implements Converter<String, SensorType> {
//
//    @Override
//    public SensorType convert(MappingContext<String, SensorType> context) {
//        String strSource = context.getSource();
//
//        switch (strSource.toUpperCase()) {
//            case "PIR":
//                return SensorType.PIR;
//            case "ACUSTIC":
//                return SensorType.ACUSTIC;
//            case "MAGNETIC":
//                return SensorType.MAGNETIC;
//            case "SEISMIC":
//                return SensorType.SEISMIC;
//            case "FIRE":
//                return SensorType.FIRE;
//
//        }
//        return null;
//    }
//
//}
