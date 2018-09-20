package org.sot.services;

import org.sot.models.Entity.Address;
import org.sot.models.Entity.ControlBoard;
import org.sot.models.Entity.Point;
import org.sot.models.requests.PointRequestModel;
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
	public boolean register(PointRequestModel prm) {
		Address address = prm.getAddress();
		ControlBoard controlBoard = prm.getControlBoard();
		Point point = new Point();
		point.setName(prm.getPoint().getName());
		point.setIdentifier(prm.getPoint().getIdentifier());
		point.setPlace(prm.getPlace());
		point.setAddress(address);
		point.setControlBoard(controlBoard);
		point.setLat(Double.parseDouble(prm.getLatitude()));
		point.setLng(Double.parseDouble(prm.getLongitude()));
		addressRepository.save(address).getId();
		controlBoardRepository.save(controlBoard);
		if (null == pointrepository.save(point).getId()) {
			return false;
		}
		return true;
	}

}
