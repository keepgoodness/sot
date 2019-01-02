package org.sot.controller;

import java.util.Comparator;
import java.util.List;
import javax.validation.Valid;
import org.hibernate.internal.util.compare.ComparableComparator;
import org.sot.exceptions.ExistingIdentifierException;
import org.sot.exceptions.ExistingPointException;
import org.sot.models.bindings.PointAtrBindingModel;
import org.sot.models.bindings.SensorCreateBindingModel;
import org.sot.models.entities.Brand;
import org.sot.models.entities.Point;
import org.sot.models.entities.Sensor;
import org.sot.repositories.BrandRepository;
import org.sot.repositories.Pointrepository;
import org.sot.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jordan
 */
@Controller
public class SensorController {

	private final BrandRepository brandRepo;
	private final Pointrepository pointRepo;
	private final SensorService sensorService;

	@Autowired
	public SensorController(BrandRepository br, Pointrepository pr, SensorService sensorService) {
		this.brandRepo = br;
		this.pointRepo = pr;
		this.sensorService = sensorService;
	}

	@ModelAttribute(name = "sensors")
	private List<Sensor> sensors() {
		List<Sensor> list = sensorService.getAllSensors();
		list.sort(new Comparator<Sensor>() {
			@Override
			public int compare(Sensor o1, Sensor o2) {
				return o1.getBrand().getName().compareTo(o2.getBrand().getName());
			}
		}
		);
		return list;
	}

	@ModelAttribute(name = "brands")
	private List<Brand> brands() {
		List<Brand> brands = brandRepo.findAll();
		brands.forEach(b -> b.setName(b.getName().toUpperCase()));
		brands.sort(new Comparator<Brand>() {
			@Override
			public int compare(Brand o1, Brand o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return brands;
	}

	@GetMapping("/sensors")
	public String allSensors(Model model) {
		model.addAttribute("title", "Датчици");
		return "components/sensors";
	}

	@GetMapping("/sensor-create")
	public String sensorCreate(@ModelAttribute SensorCreateBindingModel sensorCreateBindingModel, Model model) {
		model.addAttribute("title", "Добави датчик");
		return "components/sensor-create";
	}

	@PostMapping("/sensor-create")
	public String sensorCreate(Model model, @Valid @ModelAttribute SensorCreateBindingModel sensorCreateBindingModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "components/sensor-create";
		}

		sensorService.create(sensorCreateBindingModel);
		return "redirect:/sensors";
	}

	@GetMapping("/sensor-update/{id}")
	public String updateSensor(@PathVariable("id") String id, Model model) {
		SensorCreateBindingModel bindModel = sensorService.fillSensorBindModelById(id);
		model.addAttribute("bindModel", bindModel);
		return "components/sensor-update";
	}

	@PostMapping("/sensor-update")
	public String sensorUpdate(Model model, @Valid @ModelAttribute SensorCreateBindingModel bindModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "components/sensor-update";
		}
		sensorService.create(bindModel);
		return "redirect:/sensors";
	}

	@PostMapping("/sensor-delete")
	public ResponseEntity deleteSensor(@RequestParam("id") String id, Model model) {
		if (id.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		this.sensorService.delete(Long.parseLong(id));
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/sensor")
	public String showSensor(@RequestParam("id") String id, Model model) {
		Sensor s = sensorService.getSensorById(id);
		model.addAttribute("sensor", s);
		return "/fragments/parts :: sensor";
	}
}
