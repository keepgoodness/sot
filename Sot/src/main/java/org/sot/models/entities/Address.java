package org.sot.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(nullable = true)
	private Place place;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(nullable = true)
	private Street street;

	@Length(max = 3, message = "Номерът не трябва да надвишава 3 символа")
	@Column(length = 3, nullable = true)
	private String number;

	@Length(max = 2, message = "Входът не трябва да надвишава 2 символа")
	@Column(length = 2, nullable = true)
	private String entrance;

	@Length(max = 3, message = "Етажът не трябва да надвишава 3 символа")
	@Column(length = 3, nullable = true)
	private String floor;

	@Length(max = 3, message = "Апартаментът не трябва да надвишава 3 символа")
	@Column(length = 3, nullable = true)
	private String apartment;

	public Address() {
	}

	public Address(Street street, String number, String entrance, String floor, String apartment) {
		this.street = street;
		this.number = number;
		this.entrance = entrance;
		this.floor = floor;
		this.apartment = apartment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
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

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

//    @Override
//    public String toString() {
//        try {
//            return "\"address\":" + new ObjectMapper().writeValueAsString(this);
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(Address.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "";
//        //		return "\"address\":{" + "\"street\":\"" + street + "\", \"number\":\"" + number + "\", \"entrance\":\"" + entrance + "\", \"floor\":\"" + floor + "\"}";
//    }
}
