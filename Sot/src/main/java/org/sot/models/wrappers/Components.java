package org.sot.models.wrappers;

import java.util.List;
import org.sot.models.entities.ControlBoard;
import org.sot.models.entities.Sensor;

/**
 *
 * @author Jordan
 */
public class Components {
	
	private List<Sensor> sensors;
	private List<ControlBoard> controlBoards;

	public Components() {
	}
	
	public Components(List<Sensor> sensors, List<ControlBoard> controlBoards) {
		this.sensors = sensors;
		this.controlBoards = controlBoards;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public List<ControlBoard> getControlBoards() {
		return controlBoards;
	}

	public void setControlBoards(List<ControlBoard> controlBoards) {
		this.controlBoards = controlBoards;
	}
}
