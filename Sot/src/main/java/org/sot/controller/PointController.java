package org.sot.controller;

import javax.validation.Valid;
import org.sot.models.bindings.PointBindingModel;
import org.sot.services.BrandService;
import org.sot.services.PlaceService;
import org.sot.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Jordan
 */
@Controller
public class PointController {

	private final BrandService brandService;
	private final PlaceService placeService;
	private final PointService pointService;

	@Autowired
	public PointController(BrandService brandService, PlaceService placeService, PointService pointService) {
		this.brandService = brandService;
		this.placeService = placeService;
		this.pointService = pointService;
	}

	@GetMapping("point-create")
	public String pointCreate(@ModelAttribute PointBindingModel pointBindingModel, Model model) {
		model.addAttribute("title", "Създаване на обект");
		pointBindingModel.setPlaces(placeService.findAllPlaces());
		pointBindingModel.setBrands(brandService.findAllBrands());
		model.addAttribute("allPoints", pointService.getPointsAsJsonArray().toString());
		return "points/pointCreate";
	}

	@PostMapping("point-create")
	public String pointCreate(Model model, @Valid @ModelAttribute PointBindingModel prm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "points/pointCreate";
		}
		this.pointService.register(prm);
		return "redirect:/";
	}
}
