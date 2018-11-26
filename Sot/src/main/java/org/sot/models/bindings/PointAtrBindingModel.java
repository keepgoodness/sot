package org.sot.models.bindings;

import java.util.List;
import javax.validation.Valid;
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
	
	@Valid
	private Point point;

//	private List<Place> places;
	private String latitude;
	private String longitude;
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

//	public List<Place> getPlaces() {
//		return places;
//	}
//
//	public void setPlaces(List<Place> places) {
//		this.places = places;
//	}
        
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
