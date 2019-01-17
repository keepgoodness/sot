package org.sot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;
import org.modelmapper.ModelMapper;
import org.sot.enums.SensorType;
import org.sot.models.entities.Brand;
import org.sot.models.entities.ControlBoard;
import org.sot.models.entities.Point;
import org.sot.models.entities.Sensor;
import org.sot.models.wrappers.Car;
import org.sot.models.wrappers.Components;
import org.sot.repositories.BrandRepository;
import org.sot.repositories.ControlBoardRepository;
import org.sot.repositories.Pointrepository;
import org.sot.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	private final ModelMapper mapper;

	@Autowired
	public ComponentsController(Pointrepository pointrepository, SensorRepository sensorRepository, ControlBoardRepository boardRepository, BrandRepository brandRepository, ModelMapper mapper) {
		this.pointrepository = pointrepository;
		this.sensorRepository = sensorRepository;
		this.boardRepository = boardRepository;
		this.brandRepository = brandRepository;
		this.mapper = mapper;
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
		Point point = pointrepository.findById(Long.parseLong(id)).get();

		model.addAttribute("point", point);
		return "components/components-add";
	}

	@PostMapping("/components-add")
	public @ResponseBody
	String insertComponents(@RequestBody Components components) {
		//		https://www.codejava.net/frameworks/hibernate/hibernate-many-to-many-association-with-extra-columns-in-join-table-example
		List<Sensor> sensors = components.getSensors();
		sensors.stream().forEach(s -> {
			try {
				System.out.println(new ObjectMapper().writeValueAsString(s));
			} catch (JsonProcessingException ex) {
				Logger.getLogger(ComponentsController.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		components.getControlBoards().stream().forEach(c -> {
			try {
				System.out.println(new ObjectMapper().writeValueAsString(c));
			} catch (JsonProcessingException ex) {
				Logger.getLogger(ComponentsController.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		return "";
	}
}
