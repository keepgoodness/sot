package org.sot.controller;

import org.sot.models.requests.PointRequestModel;
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

	private final BrandService brandService;
	private final PlaceService placeService;

	@Autowired
	public HomeController(BrandService brandService, PlaceService placeService) {
		this.brandService = brandService;
		this.placeService = placeService;
	}

	@GetMapping("/")
	public String home(Model model) {
		PointRequestModel pointModel = new PointRequestModel();
		model.addAttribute("title", "Карти");
		model.addAttribute("pointRequestModel", pointModel);
		return "index";
	}

	@GetMapping("point-create")
	public String pointCreate(Model model) {
		PointRequestModel pointModel = new PointRequestModel();
		pointModel.setPlaces(placeService.findAllPlaces());
		pointModel.setBrands(brandService.findAllBrands());
		model.addAttribute("title", "Създаване на обект");
		model.addAttribute("pointRequestModel", pointModel);
		return "points/pointCreate";
	}
}
