package org.sot.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.sot.enums.SensorType;
import org.sot.models.PointSensor;

/**
 *
 * @author Jordan
 */
@Entity
@Table(name = "sensors")
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(nullable = true)
	private Brand brand;

	private String model;
	private String code;

	@Column(columnDefinition = "DECIMAL default 0.00", precision = 10, scale = 2)
	private Double price;

	@Enumerated(EnumType.ORDINAL)
	@Column(columnDefinition = "tinyint")
	private SensorType type;

	@OneToMany(mappedBy = "sensor")
	@JsonIgnore
	private Set<PointSensor> pointSensors = new HashSet<>();

	public Sensor() {
	}

	public Sensor(Brand brand, String model, String code, Double price, SensorType type) {
		this.brand = brand;
		this.model = model;
		this.code = code;
		this.price = price;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public SensorType getType() {
		return type;
	}

	public void setType(SensorType type) {
		this.type = type;
	}

	public Set<PointSensor> getPointSensors() {
		return pointSensors;
	}

	public void setPointSensors(Set<PointSensor> pointSensors) {
		this.pointSensors = pointSensors;
	}

	public boolean addPointSensor(PointSensor pointsensor) {
		return pointSensors.add(pointsensor);
	}

}
