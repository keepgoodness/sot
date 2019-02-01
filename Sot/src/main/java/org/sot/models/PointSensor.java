package org.sot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.sot.models.entities.Point;
import org.sot.models.entities.Sensor;

/**
 *
 * @author Jordan
 */
@Entity
@Table(name = "point_sensor")
public class PointSensor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "point_id")
	private Point point;
	
	@ManyToOne
	@JoinColumn(name = "sensor_id")
	private Sensor sensor;

	@Column(columnDefinition = "tinyint")
	private int quantity;

	public PointSensor() {
	}

	public PointSensor(Point point, Sensor sensor, int quantity) {
		this.point = point;
		this.sensor = sensor;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
