package org.sot.models.requests;

import java.util.List;
import org.sot.models.Entity.Address;
import org.sot.models.Entity.Brand;
import org.sot.models.Entity.Place;

/**
 *
 * @author Jordan
 */
public class PointRequestModel {
	
	private String pointName;
	private String pointIdentifier;
	private Address address;
	private List<Place> places;
	private List<Brand> brands;
	private String controlBoardBrand;
	private String controlBoardModel;

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getPointIdentifier() {
		return pointIdentifier;
	}

	public void setPointIdentifier(String pointIdentifier) {
		this.pointIdentifier = pointIdentifier;
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

	public String getControlBoardBrand() {
		return controlBoardBrand;
	}

	public void setControlBoardBrand(String controlBoardBrand) {
		this.controlBoardBrand = controlBoardBrand;
	}

	public String getControlBoardModel() {
		return controlBoardModel;
	}

	public void setControlBoardModel(String controlBoardModel) {
		this.controlBoardModel = controlBoardModel;
	}
}
