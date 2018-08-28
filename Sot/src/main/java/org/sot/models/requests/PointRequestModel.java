package org.sot.models.requests;
/**
 *
 * @author Jordan
 */
public class PointRequestModel {
	
	private String pointName;
	private String pointIdentifier;
	private String controlBoardBrand;
	private String controlBoardModel;
	private String sensorBrand;
	private String sensorModel;

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

	public String getSensorBrand() {
		return sensorBrand;
	}

	public void setSensorBrand(String sensorBrand) {
		this.sensorBrand = sensorBrand;
	}

	public String getSensorModel() {
		return sensorModel;
	}

	public void setSensorModel(String sensorModel) {
		this.sensorModel = sensorModel;
	}
}
