package org.sot.models.bindings;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.sot.models.entities.Address;
import org.sot.models.entities.Company;
import org.sot.models.entities.Place;
import org.sot.models.entities.Point;

/**
 *
 * @author Jordan
 */
public class PointAtrBindingModel {

	@Size(min = 1, max = 10, message = "ID на обекта не трябва да надвишава 10 символа!")
	private String identifier;
	
	@Size(min = 1, max = 100, message = "Името на обекта  е между 1 и 100 символа!")
	private String name;
	
	private Double lat;
	private Double lng;

	private String addressPlaceId;
    private String addressPlaceName;
	
	@Size(max = 60, message = "Улицата не трябва да надвишава 60 символа")
    private String addressStreetName;

    @Size(max = 3, message = "Номерът не трябва да надвишава 3 символа")
    private String addressNumber;

    @Size(max = 2, message = "Входът не трябва да надвишава 2 символа")
    private String addressEntrance;

    @Size(max = 3, message = "Етажът не трябва да надвишава 3 символа")
    private String addressFloor;

    @Size(max = 3, message = "Апартаментът не трябва да надвишава 3 символа")
    private String addressApartment;

	public String getIdentifier() {
		return identifier;
	}

	public String getAddressPlaceId() {
		return addressPlaceId;
	}

	public void setAddressPlaceId(String addressPlaceId) {
		this.addressPlaceId = addressPlaceId;
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

	public String getAddressPlaceName() {
		return addressPlaceName;
	}

	public void setAddressPlaceName(String addressPlaceName) {
		this.addressPlaceName = addressPlaceName;
	}

	public String getAddressStreetName() {
		return addressStreetName;
	}

	public void setAddressStreetName(String addressStreetName) {
		this.addressStreetName = addressStreetName;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressEntrance() {
		return addressEntrance;
	}

	public void setAddressEntrance(String addressEntrance) {
		this.addressEntrance = addressEntrance;
	}

	public String getAddressFloor() {
		return addressFloor;
	}

	public void setAddressFloor(String addressFloor) {
		this.addressFloor = addressFloor;
	}

	public String getAddressApartment() {
		return addressApartment;
	}

	public void setAddressApartment(String addressApartment) {
		this.addressApartment = addressApartment;
	}
	
}
