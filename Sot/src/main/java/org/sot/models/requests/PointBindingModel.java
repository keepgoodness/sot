package org.sot.models.requests;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.sot.models.Entity.Address;
import org.sot.models.Entity.Brand;
import org.sot.models.Entity.ControlBoard;
import org.sot.models.Entity.Place;
import org.sot.models.Entity.Point;

/**
 *
 * @author Jordan
 */
public class PointBindingModel {
	
	@Valid
	private Point point;
	@Valid
	private Address address;
	@Valid
	private Place place;
	private List<Place> places;
	private List<Brand> brands;
	@Valid
	private ControlBoard controlBoard;
	private String latitude;
	private String longitude;

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

	public ControlBoard getControlBoard() {
		return controlBoard;
	}

	public void setControlBoard(ControlBoard controlBoard) {
		this.controlBoard = controlBoard;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
