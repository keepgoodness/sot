package org.sot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.sot.enums.SensorType;
import org.sot.models.entities.ControlBoard;
import org.sot.models.entities.Point;
import org.sot.models.entities.Sensor;
import org.sot.repositories.ControlBoardRepository;
import org.sot.repositories.Pointrepository;
import org.sot.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Jordan
 */
@Controller
public class ComponentsController {

	private final Pointrepository pointrepository;
	private final SensorRepository sensorRepository;
	private final ControlBoardRepository boardRepository;
	private final ModelMapper mapper;

	@Autowired
	public ComponentsController(Pointrepository pointrepository, SensorRepository sensorRepository, ControlBoardRepository boardRepository, ModelMapper mapper) {
		this.pointrepository = pointrepository;
		this.sensorRepository = sensorRepository;
		this.boardRepository = boardRepository;
		this.mapper = mapper;
	}

	

	@GetMapping("/components_add/{id}")
	public String componentsAdd(@PathVariable("id") String id, Model model) throws JsonProcessingException {

		Point point = pointrepository.findById(Long.parseLong(id)).get();
		Sensor sensor = sensorRepository.findById(Long.parseLong("90")).get();
		Sensor sensor2 = sensorRepository.findById(Long.parseLong("95")).get();
		ControlBoard board = boardRepository.findById(Long.parseLong("92")).get();
		
		ObjectMapper objMapper = new ObjectMapper();
		String json = objMapper.writeValueAsString(sensor.getPoints().get(0));
		System.out.println(json);
		
		model.addAttribute("point", sensor.getPoints().get(0));

		return "components/components-add";
	}
}
