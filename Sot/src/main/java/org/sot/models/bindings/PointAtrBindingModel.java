package org.sot.models.bindings;

import java.util.List;
import javax.validation.constraints.Size;
import org.sot.models.entities.ResponsiblePerson;
import org.sot.models.entities.ResponsiblePerson;

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

	// *** Sddress ***
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

	// *** Ssestatus ***
	private String sseStatus;
	private boolean hasSot;
	private boolean hasVideo;

	// *** Company ***
	@Size(max = 15, message = "Булстатът не трябва да надвишава 15 символа")
	private String companyBulstat;
	
	@Size(max = 60, message = "МОЛ - името не трябва да надвишава 60 символа")
	private String companyMrpFirstName;
	@Size(max = 60, message = "МОЛ - бащиното име не трябва да надвишава 60 символа")
	private String companyMrpMiddleName;
	@Size(max = 60, message = "МОЛ - фамилията не трябва да надвишава 60 символа")
	private String companyMrpLastName;
	
	@Size(max = 60, message = "Името на получателя не трябва да надвишава 60 символа")
	private String companyRecipientFirstName;
	@Size(max = 60, message = "Бащиното име на получателя не трябва да надвишава 60 символа")
	private String companyRecipientMiddleName;
	@Size(max = 60, message = "Фамилията на получателя не трябва да надвишава 60 символа")
	private String companyRecipientLastName;
	
	private String companyAddressPlaceId;
	private String companyAddressPlaceName;

	@Size(max = 60, message = "Улицата не трябва да надвишава 60 символа")
	private String companyAddressStreetName;

	@Size(max = 3, message = "Номерът не трябва да надвишава 3 символа")
	private String companyAddressNumber;

	@Size(max = 2, message = "Входът не трябва да надвишава 2 символа")
	private String companyAddressEntrance;

	@Size(max = 3, message = "Етажът не трябва да надвишава 3 символа")
	private String companyAddressFloor;

	@Size(max = 3, message = "Апартаментът не трябва да надвишава 3 символа")
	private String companyAddressApartment;

	private List<ResponsiblePerson> responsiblePersons;

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

	public String getSseStatus() {
		return sseStatus;
	}

	public void setSseStatus(String sseStatus) {
		this.sseStatus = sseStatus;
	}

	public boolean isHasSot() {
		return hasSot;
	}

	public void setHasSot(boolean hasSot) {
		this.hasSot = hasSot;
	}

	public boolean isHasVideo() {
		return hasVideo;
	}

	public void setHasVideo(boolean hasVideo) {
		this.hasVideo = hasVideo;
	}

	public List<ResponsiblePerson> getResponsiblePersons() {
		return responsiblePersons;
	}

	public void setResponsiblePersons(List<ResponsiblePerson> responsiblePersons) {
		this.responsiblePersons = responsiblePersons;
	}

	public String getCompanyBulstat() {
		return companyBulstat;
	}

	public void setCompanyBulstat(String companyBulstat) {
		this.companyBulstat = companyBulstat;
	}

	public String getCompanyMrpFirstName() {
		return companyMrpFirstName;
	}

	public void setCompanyMrpFirstName(String companyMrpFirstName) {
		this.companyMrpFirstName = companyMrpFirstName;
	}

	public String getCompanyMrpMiddleName() {
		return companyMrpMiddleName;
	}

	public void setCompanyMrpMiddleName(String companyMrpMiddleName) {
		this.companyMrpMiddleName = companyMrpMiddleName;
	}

	public String getCompanyMrpLastName() {
		return companyMrpLastName;
	}

	public void setCompanyMrpLastName(String companyMrpLastName) {
		this.companyMrpLastName = companyMrpLastName;
	}

	public String getCompanyRecipientFirstName() {
		return companyRecipientFirstName;
	}

	public void setCompanyRecipientFirstName(String companyRecipientFirstName) {
		this.companyRecipientFirstName = companyRecipientFirstName;
	}

	public String getCompanyRecipientMiddleName() {
		return companyRecipientMiddleName;
	}

	public void setCompanyRecipientMiddleName(String companyRecipientMiddleName) {
		this.companyRecipientMiddleName = companyRecipientMiddleName;
	}

	public String getCompanyRecipientLastName() {
		return companyRecipientLastName;
	}

	public void setCompanyRecipientLastName(String companyRecipientLastName) {
		this.companyRecipientLastName = companyRecipientLastName;
	}

	public String getCompanyAddressPlaceId() {
		return companyAddressPlaceId;
	}

	public void setCompanyAddressPlaceId(String companyAddressPlaceId) {
		this.companyAddressPlaceId = companyAddressPlaceId;
	}

	public String getCompanyAddressPlaceName() {
		return companyAddressPlaceName;
	}

	public void setCompanyAddressPlaceName(String companyAddressPlaceName) {
		this.companyAddressPlaceName = companyAddressPlaceName;
	}

	public String getCompanyAddressStreetName() {
		return companyAddressStreetName;
	}

	public void setCompanyAddressStreetName(String companyAddressStreetName) {
		this.companyAddressStreetName = companyAddressStreetName;
	}

	public String getCompanyAddressNumber() {
		return companyAddressNumber;
	}

	public void setCompanyAddressNumber(String companyAddressNumber) {
		this.companyAddressNumber = companyAddressNumber;
	}

	public String getCompanyAddressEntrance() {
		return companyAddressEntrance;
	}

	public void setCompanyAddressEntrance(String companyAddressEntrance) {
		this.companyAddressEntrance = companyAddressEntrance;
	}

	public String getCompanyAddressFloor() {
		return companyAddressFloor;
	}

	public void setCompanyAddressFloor(String companyAddressFloor) {
		this.companyAddressFloor = companyAddressFloor;
	}

	public String getCompanyAddressApartment() {
		return companyAddressApartment;
	}

	public void setCompanyAddressApartment(String companyAddressApartment) {
		this.companyAddressApartment = companyAddressApartment;
	}
}
