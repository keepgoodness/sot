package org.sot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.sot.enums.SensorType;
import org.sot.models.bindings.SensorCreateBindingModel;
import org.sot.models.entities.Point;
import org.sot.models.entities.Sensor;
import org.sot.repositories.ControlBoardRepository;
import org.sot.repositories.Pointrepository;
import org.sot.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jordan
 */
@Service
public class SensorService {

	private final SensorRepository sensorRepository;
	private final Pointrepository pointrepository;
	private final ControlBoardRepository boardRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public SensorService(SensorRepository sRepo, ModelMapper modelMapper, ControlBoardRepository boardRepository, Pointrepository pointrepository) {
		this.sensorRepository = sRepo;
		this.modelMapper = modelMapper;
		this.boardRepository = boardRepository;
		this.pointrepository = pointrepository;
	}

	public List<Sensor> getAllSensors() {
		return sensorRepository.findAll();
	}

	public SensorCreateBindingModel fillSensorBindModelById(String id) {
		Sensor s = sensorRepository.findById(Long.parseLong(id)).get();
		return modelMapper.map(s, SensorCreateBindingModel.class);

	}

	public void create(SensorCreateBindingModel bindingModel) {
		Sensor s = modelMapper.map(bindingModel, Sensor.class);
		sensorRepository.save(s);
	}

	public boolean delete(Long id) {
		this.sensorRepository.deleteById(id);
		return !this.sensorRepository.findById(id).isPresent();
	}

	public Sensor getSensorById(String id) {
		return sensorRepository.getOne(Long.parseLong(id));
	}

	public List<Sensor> findAllByBrandId(String brandId) {
		return sensorRepository.findAllByBrandId(Long.parseLong(brandId));
	}

	public List<Sensor> getSensorsByTypeAndBrand(SensorType type, String brandId) {
		return sensorRepository.findAllByBrandIdAndType(type, Long.parseLong(brandId));

	}

	public List<Sensor> getAllSensorsByPoint(String pointId) {
//		return pointrepository.getOne(Long.parseLong(pointId)).getSensors();
		return null;
	}
}
