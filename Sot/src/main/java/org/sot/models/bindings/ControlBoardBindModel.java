package org.sot.models.bindings;

import javax.validation.constraints.Size;

/**
 *
 * @author Jordan
 */
public class ControlBoardBindModel {

	private String controlBoardId;
	private String controlBoardBrandId;
	@Size(max = 20, message = "Модела не може да надвишава 20 символа")
	private String controlBoardModel;
	@Size(max = 10, message = "Кода не може да надвишава 10 символа")
	private String controlBoardCode;
	private String controlBoardPrice;
	private String controlBoardLink;

	public ControlBoardBindModel() {
	}
	

	public String getControlBoardId() {
		return controlBoardId;
	}

	public void setControlBoardId(String controlBoardId) {
		this.controlBoardId = controlBoardId;
	}

	public String getControlBoardBrandId() {
		return controlBoardBrandId;
	}

	public void setControlBoardBrandId(String controlBoardBrandId) {
		this.controlBoardBrandId = controlBoardBrandId;
	}

	public String getControlBoardModel() {
		return controlBoardModel;
	}

	public void setControlBoardModel(String controlBoardModel) {
		this.controlBoardModel = controlBoardModel;
	}

	public String getControlBoardCode() {
		return controlBoardCode;
	}

	public void setControlBoardCode(String controlBoardCode) {
		this.controlBoardCode = controlBoardCode;
	}

	public String getControlBoardPrice() {
		return controlBoardPrice;
	}

	public void setControlBoardPrice(String controlBoardPrice) {
		this.controlBoardPrice = controlBoardPrice;
	}

	public String getControlBoardLink() {
		return controlBoardLink;
	}

	public void setControlBoardLink(String controlBoardLink) {
		this.controlBoardLink = controlBoardLink;
	}
}
