package org.sot.models.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Jordan
 */
@Entity(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Length(max = 60, message = "Улицата не трябва да надвишава 60 символа")
	private String street;
	@Length(max = 3, message = "Номерът не трябва да надвишава 3 символа")
	private String number;
	@Length(max = 2, message = "Входът не трябва да надвишава 2 символа")
	private String entrance;
	@Length(max = 3, message = "Етажът не трябва да надвишава 3 символа")
	private String floor;

	@OneToOne(mappedBy = "address")
	private Point point;

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Address(Address address) {
		this.street = address.getStreet();
		this.number = address.getNumber();
		this.entrance = address.getEntrance();
		this.floor = address.getFloor();
	}

	public Address() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEntrance() {
		return entrance;
	}

	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

}
