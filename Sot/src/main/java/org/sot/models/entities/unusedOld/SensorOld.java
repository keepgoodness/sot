///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.sot.models.entities.unusedOld;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import org.sot.enums.SensorType;
//import org.sot.models.entities.Brand;
//import org.sot.models.entities.Point;
//
///**
// *
// * @author Jordan
// */
//@Entity
//@Table(name = "sensors")
//public class Sensor {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//
//	@ManyToOne
//	@JoinColumn(nullable = true)
//	private Brand brand;
//
//	private String model;
//	private String code;
//
//	@Column(columnDefinition = "DECIMAL default 0.00", precision = 10, scale = 2)
//	private Double price;
//
//	@Enumerated(EnumType.ORDINAL)
//	@Column(columnDefinition = "tinyint")
//	private SensorType type;
//
//	@ManyToMany(fetch = FetchType.LAZY,
//			cascade = {
//				CascadeType.PERSIST,
//				CascadeType.MERGE
//			},
//			mappedBy = "sensors")
//	@JsonIgnore
//	private List<Point> points;
//
//	public List<Point> getPoints() {
//		return points;
//	}
//
//	public void setPoints(List<Point> points) {
//		this.points = points;
//	}
//
//	public Sensor() {
//	}
//
//	public Sensor(Brand brand, String model, String code, Double price, SensorType type, List<Point> points) {
//		this.brand = brand;
//		this.model = model;
//		this.code = code;
//		this.price = price;
//		this.type = type;
//		this.points = points;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Brand getBrand() {
//		return brand;
//	}
//
//	public void setBrand(Brand brand) {
//		this.brand = brand;
//	}
//
//	public String getModel() {
//		return model;
//	}
//
//	public void setModel(String model) {
//		this.model = model;
//	}
//
//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	public Double getPrice() {
//		return price;
//	}
//
//	public void setPrice(Double price) {
//		this.price = price;
//	}
//
//	public SensorType getType() {
//		return type;
//	}
//
//	public void setType(SensorType type) {
//		this.type = type;
//	}
//
//}
