package org.sot.services;

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

}
