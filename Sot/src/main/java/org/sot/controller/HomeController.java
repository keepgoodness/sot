package org.sot.controller;

import java.util.List;
import org.sot.models.Entity.Point;
import org.sot.models.requests.PointRequestModel;
import org.sot.repositories.Pointrepository;
import org.sot.services.BrandService;
import org.sot.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jordan
 */
@Controller
public class HomeController {

	private final Pointrepository pointrepository;

	@Autowired
	public HomeController(Pointrepository pointrepository) {
		this.pointrepository = pointrepository;
	}

	@GetMapping("/")
	public String home(Model model) {
		PointRequestModel pointModel = new PointRequestModel();
		model.addAttribute("title", "Карти");
		List<Point> allPoints = this.pointrepository.findAll();
		model.addAttribute("allPoints", allPoints);
		model.addAttribute("pointRequestModel", pointModel);
		return "index";
	}

}
