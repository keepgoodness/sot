//package org.sot.models.entities;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlType;
//
///**
// *
// * @author Jordan
// */
//@Entity(name = "markers")
//@XmlRootElement(name = "marker")
//@XmlType(propOrder = {"id", "name", "address", "lat", "lng", "type"})
//public class Marker implements Serializable {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//
//	@Column(length = 60, nullable = false)
//	private String name;
//
//	@Column(length = 80, nullable = false)
//	private String address;
//
//	@Column(columnDefinition = "float(10,6)", nullable = false)
//	private float lat;
//
//	@Column(columnDefinition = "float(10,6)", nullable = false)
//	private float lng;
//
//	@Column(length = 30, nullable = false)
//	private String type;
//
//	public Long getId() {
//		return id;
//	}
//
//	@XmlAttribute
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	@XmlAttribute
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	@XmlAttribute
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public float getLat() {
//		return lat;
//	}
//
//	@XmlAttribute
//	public void setLat(float lat) {
//		this.lat = lat;
//	}
//
//	public float getLng() {
//		return lng;
//	}
//
//	@XmlAttribute
//	public void setLng(float lng) {
//		this.lng = lng;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	@XmlAttribute
//	public void setType(String type) {
//		this.type = type;
//	}
//}
