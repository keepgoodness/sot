/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.models.requests;

import java.util.List;
import org.sot.models.Entity.Brand;

/**
 *
 * @author Jordan
 */
public class PointRequestModel {
	
	private String pointName;
	private String pointIdentifier;
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
