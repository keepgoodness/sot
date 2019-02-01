package org.sot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.modelmapper.ModelMapper;
import org.sot.enums.SensorType;
import org.sot.models.PointSensor;
import org.sot.models.entities.Brand;
import org.sot.models.entities.Point;
import org.sot.models.entities.Sensor;
import org.sot.models.wrappers.PointComponentsRequest;
import org.sot.models.wrappers.SensorRequest;
import org.sot.repositories.BrandRepository;
import org.sot.repositories.ControlBoardRepository;
import org.sot.repositories.PointSensorRepository;
import org.sot.repositories.Pointrepository;
import org.sot.repositories.SensorRepository;
import org.sot.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jordan
 */
@Controller
public class ComponentsController {

	private final Pointrepository pointrepository;
	private final SensorRepository sensorRepository;
	private final ControlBoardRepository boardRepository;
	private final BrandRepository brandRepository;
	private final PointSensorRepository psRepo;

	private final SensorService sensorService;
	private final ModelMapper mapper;

	@Autowired
	public ComponentsController(Pointrepository pointrepository, SensorRepository sensorRepository, ControlBoardRepository boardRepository, BrandRepository brandRepository, SensorService sensorService, ModelMapper mapper, PointSensorRepository pointSensorRepository) {
		this.pointrepository = pointrepository;
		this.sensorRepository = sensorRepository;
		this.boardRepository = boardRepository;
		this.brandRepository = brandRepository;
		this.sensorService = sensorService;
		this.mapper = mapper;
		this.psRepo = pointSensorRepository;
	}

	@ModelAttribute(name = "brands")
	private List<Brand> brands() {
		List<Brand> brands = brandRepository.findAll();
		brands.forEach(b -> b.setName(b.getName().toUpperCase()));
		brands.sort(new Comparator<Brand>() {
			@Override
			public int compare(Brand o1, Brand o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return brands;
	}

	@GetMapping("/components_add/{id}")
	public String componentsAdd(@PathVariable("id") String id, Model model) throws JsonProcessingException {
		Point point = pointrepository.getOne(Long.parseLong(id));
//		psRepo.save(new PointSensor(point, sensorRepository.getOne(Long.parseLong("5")), 12));
		System.out.println(new ObjectMapper().writeValueAsString(point.getPointSensors()));
		model.addAttribute("sensors", point.getPointSensors());
		model.addAttribute("point", point);
		return "components/components-add";
	}

	@PostMapping("/components-add")
	public @ResponseBody
	String insertComponents(@RequestBody PointComponentsRequest components) {
		//		https://www.codejava.net/frameworks/hibernate/hibernate-many-to-many-association-with-extra-columns-in-join-table-example
//		Point p = pointrepository.getOne(Long.parseLong(components.getPointId()));
//		List<SensorRequest> requests = components.getSensors();
//		List<Sensor> pSensors = p.getSensors();
//		requests.forEach(e -> pSensors.add(sensorService.getSensorById(e.getId())));
//		pointrepository.save(p);

		return "";
	}

	@PostMapping(value = "/api/components-add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Sensor> getModels(HttpEntity<String> httpEntity) throws IOException {
		String json = httpEntity.getBody();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode obj = mapper.readTree(json);

		return sensorService.getSensorsByTypeAndBrand(
				SensorType.valueOf(obj.get("sensorType").textValue()),
				obj.get("brandId").textValue());
	}
}
