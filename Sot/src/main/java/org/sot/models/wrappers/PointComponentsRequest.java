package org.sot.models.wrappers;

import java.util.List;

/**
 *
 * @author Jordan
 */
public class PointComponentsRequest {

	private String pointId;
	private List<SensorRequest> sensors;
	private List<ControlBoardsRequest> controlBoards;

	public PointComponentsRequest() {
	}

	public String getPointId() {
		return pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	public List<SensorRequest> getSensors() {
		return sensors;
	}

	public void setSensors(List<SensorRequest> sensors) {
		this.sensors = sensors;
	}

	public List<ControlBoardsRequest> getControlBoards() {
		return controlBoards;
	}

	public void setControlBoards(List<ControlBoardsRequest> controlBoards) {
		this.controlBoards = controlBoards;
	}

}
