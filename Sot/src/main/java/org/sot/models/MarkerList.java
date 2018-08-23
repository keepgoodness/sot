package org.sot.models;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.sot.models.Entity.Marker;

/**
 *
 * @author Jordan
 */
@XmlRootElement(name = "markers")
public class MarkerList {

	private List<Marker> markerList;

	public MarkerList() {
	}

	public MarkerList(List<Marker> markerList) {
		this.markerList = markerList;
	}

	@XmlElement(name = "marker")
	public List<Marker> getMarkers() {
		return markerList;
	}
}
