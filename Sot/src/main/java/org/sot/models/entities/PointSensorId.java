//package org.sot.models.entities;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import java.io.Serializable;
//import javax.persistence.CascadeType;
//import javax.persistence.Embeddable;
//import javax.persistence.ManyToOne;
//
///**
// *
// * @author Jordan
// */
//@Embeddable
//public class PointSensorId implements Serializable {
//
//	private Point point;
//	private Sensor sensor;
//
//	public PointSensorId() {
//	}
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
//	public Point getPoint() {
//		return point;
//	}
//
//	public void setPoint(Point point) {
//		this.point = point;
//	}
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	public Sensor getSensor() {
//		return sensor;
//	}
//
//	public void setSensor(Sensor sensor) {
//		this.sensor = sensor;
//	}
//	
//}
