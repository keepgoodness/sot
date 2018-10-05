package org.sot.controller;

import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import org.sot.models.bindings.PointBindingModel;
import org.sot.models.entities.Point;
import org.sot.repositories.Pointrepository;
import org.sot.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jordan
 */
@Controller
public class HomeController {

	private final PointService pointService;
	private final Pointrepository pointrepository;

	@Autowired
	public HomeController(PointService pointService, Pointrepository pointrepository) {
		this.pointService = pointService;
		this.pointrepository = pointrepository;
	}

	@GetMapping("/")
	public String home(Model model) {
		PointBindingModel pointModel = new PointBindingModel();
		model.addAttribute("title", "Карти");
		model.addAttribute("allPoints", pointService.getPointsAsJsonArray().toString());
		model.addAttribute("pointBindingModel", pointModel);
		return "index";
	}

	@ResponseBody
	@GetMapping(value = "/point", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getPoint(@RequestParam("id") String id, Model model) {
		return pointrepository.findPointById(Long.parseLong(id)).toString();
	}

	@ResponseBody
	@GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getPointsByName(@RequestParam String name, Model model) {
		System.out.println("name");
		return pointService.getPointsAutocomplete(name).toString();
	}
}
