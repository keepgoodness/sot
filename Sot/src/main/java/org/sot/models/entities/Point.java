package org.sot.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import org.sot.enums.ServiceStatus;
import org.sot.enums.VatStatus;

/**
 *
 * @author Jordan
 */
@Entity
@Table(name = "points")
public class Point {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 10, nullable = true)
	@Length(max = 10, message = "ID на обекта не трябва да надвишава 10 символа!")
	private String identifier;

	@Column(length = 100)
	@Length(min = 1, max = 100, message = "Името на обекта  е между 1 и 100 символа!")
	private String name;

	@Column
	private Double lat;

	@Column
	private Double lng;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "address_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Address address;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "place_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Place place;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "controlboard_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ControlBoard controlBoard;

	@Enumerated(EnumType.ORDINAL)
	@Column(columnDefinition = "boolean")
	private VatStatus vatStatus;

	@Column(length = 15, nullable = true)
	private String vatCode;

	@Enumerated(EnumType.ORDINAL)
	@Column(columnDefinition = "boolean", length = 1)
	private ServiceStatus serviceStatus;

	@Column(columnDefinition = "boolean", length = 1, nullable = false)
	private boolean hasSse;

	@Column(columnDefinition = "boolean", length = 1, nullable = false)
	private boolean hasVideo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public ControlBoard getControlBoard() {
		return controlBoard;
	}

	public void setControlBoard(ControlBoard controlBoard) {
		this.controlBoard = controlBoard;
	}

	public VatStatus getVatStatus() {
		return vatStatus;
	}

	public void setVatStatus(VatStatus vatStatus) {
		this.vatStatus = vatStatus;
	}

	public String getVatCode() {
		return vatCode;
	}

	public void setVatCode(String vatCode) {
		this.vatCode = vatCode;
	}

	@Override
	public String toString() {
		return "{\"point\":{" + "\"id\":" + id + ", \"identifier\":\"" + identifier + "\", \"name\":\"" + name + "\", \"lat\":\"" + lat + "\", \"lng\":\"" + lng + "\", " + address.toString() + ", " + place.toString() + ", " + controlBoard.toString() + "}}";
	}
}
