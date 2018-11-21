package org.sot.models.bindings;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.sot.models.entities.Address;
import org.sot.models.entities.Brand;
import org.sot.models.entities.ControlBoard;
import org.sot.models.entities.Place;
import org.sot.models.entities.Point;

/**
 *
 * @author Jordan
 */
public class PointAtrBindingModel {
	
	@Valid
	private Point point;
	@Valid
	private Address address;
	@Valid
	private Place place;
	private List<Place> places;
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
