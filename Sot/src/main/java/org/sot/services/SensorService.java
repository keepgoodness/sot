package org.sot.services;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.sot.models.bindings.SensorCreateBindingModel;
import org.sot.models.entities.Sensor;
import org.sot.repositories.ControlBoardRepository;
import org.sot.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jordan
 */
@Service
public class SensorService {

	private final SensorRepository sRepo;
	private final ControlBoardRepository boardRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public SensorService(SensorRepository sRepo, ModelMapper modelMapper, ControlBoardRepository boardRepository) {
		this.sRepo = sRepo;
		this.modelMapper = modelMapper;
		this.boardRepository = boardRepository;
	}

	public List<Sensor> getAllSensors() {
		return sRepo.findAll();
	}

	public SensorCreateBindingModel fillSensorBindModelById(String id) {
		Sensor s = sRepo.findById(Long.parseLong(id)).get();
		return modelMapper.map(s, SensorCreateBindingModel.class);

	}

	public void create(SensorCreateBindingModel bindingModel) {
		Sensor s = modelMapper.map(bindingModel, Sensor.class);
		sRepo.save(s);
	}

	public boolean delete(Long id) {
		this.sRepo.deleteById(id);
		return !this.sRepo.findById(id).isPresent();
	}

	public Sensor getSensorById(String id) {
		return sRepo.getOne(Long.parseLong(id));
	}

	public List<Sensor> findAllByBrandId(String brandId) {
		return sRepo.findAllByBrandId(Long.parseLong(brandId));
	}
}
