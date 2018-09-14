package org.sot.controller;

import java.util.List;
import org.sot.models.Entity.Brand;
import org.sot.models.Entity.Place;
import org.sot.models.requests.PointRequestModel;
import org.sot.services.BrandService;
import org.sot.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Jordan
 */
@Controller
public class PointController {

	private final BrandService brandService;
	private final PlaceService placeService;

	@Autowired
	public PointController(BrandService brandService, PlaceService placeService) {
		this.brandService = brandService;
		this.placeService = placeService;
	}

	@GetMapping("point-create")
	public String pointCreate(Model model) {
		model.addAttribute("title", "Създаване на обект");
		List<Place> places = placeService.findAllPlaces();
		List<Brand> brands = brandService.findAllBrands();
		
		if (model.containsAttribute("pointRequestModel")) {
			PointRequestModel prm = (PointRequestModel) model.asMap().get("pointRequestModel");
			prm.setPlaces(places);
			prm.setBrands(brands);
		} else {
			PointRequestModel pointModel = new PointRequestModel();
			pointModel.setPlaces(places);
			pointModel.setBrands(brands);
			model.addAttribute("pointRequestModel", pointModel);
		}
		return "points/pointCreate";
	}

	@PostMapping("point-create")
	public String pointCreate(Model model, PointRequestModel pointRequestModel) {
		model.addAttribute("pointRequestModel", pointRequestModel);
		return pointCreate(model);
	}
}
