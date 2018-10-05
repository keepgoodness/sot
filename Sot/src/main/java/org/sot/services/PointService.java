package org.sot.services;

import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import org.sot.models.entities.Address;
import org.sot.models.entities.ControlBoard;
import org.sot.models.entities.Point;
import org.sot.models.bindings.PointBindingModel;
import org.sot.repositories.AddressRepository;
import org.sot.repositories.ControlBoardRepository;
import org.sot.repositories.Pointrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jordan
 */
@Service
public class PointService {

	private final AddressRepository addressRepository;
	private final Pointrepository pointrepository;
	private final ControlBoardRepository controlBoardRepository;

	@Autowired
	public PointService(AddressRepository addressRepository, Pointrepository pointrepository, ControlBoardRepository controlBoardRepository) {
		this.addressRepository = addressRepository;
		this.pointrepository = pointrepository;
		this.controlBoardRepository = controlBoardRepository;
	}

	@Transactional()
	public boolean register(PointBindingModel bindingModel) {
		Address address = bindingModel.getAddress();
		ControlBoard controlBoard = bindingModel.getControlBoard();
		Point point = new Point();
		point.setName(bindingModel.getPoint().getName());
		point.setIdentifier(bindingModel.getPoint().getIdentifier());
		point.setPlace(bindingModel.getPlace());
		point.setAddress(address);
		point.setControlBoard(controlBoard);
		point.setLat(Double.parseDouble(bindingModel.getLatitude()));
		point.setLng(Double.parseDouble(bindingModel.getLongitude()));
		addressRepository.save(address).getId();
		controlBoardRepository.save(controlBoard);
		if (null == pointrepository.save(point).getId()) {
			return false;
		}
		return true;
	}

	public JsonObject getPointsAsJsonArray() {
		List<Object[]> arrayObj = this.pointrepository.findAllWithIdLatLng();
		JsonArrayBuilder array = Json.createArrayBuilder();
		for (int i = 0; i < arrayObj.size(); i++) {
			JsonObjectBuilder objBuilder = Json.createObjectBuilder();
			objBuilder.add("id", arrayObj.get(i)[0].toString());
			objBuilder.add("lat", arrayObj.get(i)[1].toString());
			objBuilder.add("lng", arrayObj.get(i)[2].toString());
			objBuilder.add("name", arrayObj.get(i)[3].toString());
			array.add(objBuilder);
		}
		JsonObject json = Json.createObjectBuilder()
				.add("point", array).build();
		return json;
	}

	public List<JsonObject> getPointsAutocomplete(String name) {
		List<Object[]> points = pointrepository.findByName(name);
//		JsonArrayBuilder array = Json.createArrayBuilder();
		List<JsonObject> array = new ArrayList<>();
		points.stream().forEach(p -> {
			JsonObjectBuilder objBuilder = Json.createObjectBuilder();
			objBuilder.add("id", p[0].toString());
			objBuilder.add("name", p[1].toString());
			array.add(objBuilder.build());
		});
//		JsonObject json = Json.createObjectBuilder()
//				.add("point", array).build();
		return array;
	}

}
