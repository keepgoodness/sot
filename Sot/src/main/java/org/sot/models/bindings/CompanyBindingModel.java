/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.models.bindings;

import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Jordan
 */
public class CompanyBindingModel {

	@Length(min = 3, max = 15, message = "Булстата е задължителен.Между 3 и 15 символа")
	private String bulstat;

	private String mrpFirstName;
	private String mrpMiddleName;
	private String mrpLastName;

	private String resipientFirstName;
	private String resipientMiddleName;
	private String resipientLastName;

	private String addressPlaceId;
	private String addressPlaceName;
	private String addressStreetName;
	private String addressNumber;
	private String addressEntrance;
	private String addressFloor;
	private String addressApartment;

	public String getBulstat() {
		return bulstat;
	}

	public void setBulstat(String bulstat) {
		this.bulstat = bulstat;
	}

	public String getMrpFirstName() {
		return mrpFirstName;
	}

	public void setMrpFirstName(String mrpFirstName) {
		this.mrpFirstName = mrpFirstName;
	}

	public String getMrpMiddleName() {
		return mrpMiddleName;
	}

	public void setMrpMiddleName(String mrpMiddleName) {
		this.mrpMiddleName = mrpMiddleName;
	}

	public String getMrpLastName() {
		return mrpLastName;
	}

	public void setMrpLastName(String mrpLastName) {
		this.mrpLastName = mrpLastName;
	}

	public String getResipientFirstName() {
		return resipientFirstName;
	}

	public void setResipientFirstName(String resipientFirstName) {
		this.resipientFirstName = resipientFirstName;
	}

	public String getResipientMiddleName() {
		return resipientMiddleName;
	}

	public void setResipientMiddleName(String resipientMiddleName) {
		this.resipientMiddleName = resipientMiddleName;
	}

	public String getResipientLastName() {
		return resipientLastName;
	}

	public void setResipientLastName(String resipientLastName) {
		this.resipientLastName = resipientLastName;
	}

	public String getAddressPlaceId() {
		return addressPlaceId;
	}

	public void setAddressPlaceId(String addressPlaceId) {
		this.addressPlaceId = addressPlaceId;
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
