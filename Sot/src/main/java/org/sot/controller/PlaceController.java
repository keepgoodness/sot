package org.sot.controller;

import org.sot.models.requests.PlaceCreateRequestModel;
import org.sot.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jordan
 */
@Controller
public class PlaceController {

	private final PlaceService placeService;

	@Autowired
	public PlaceController(PlaceService placeService) {
		this.placeService = placeService;
	}

	@GetMapping("/allPlaces")
	public String allBrands(Model model) {
		model.addAttribute("title", "Населени места");
		model.addAttribute("allPlaces", this.placeService.findAllPlaces());
		return "components/allPlaces";
	}

	@GetMapping("/place-create")
	public String register(Model model) {
		model.addAttribute("title", "Населено място");
		PlaceCreateRequestModel createRequestModel = new PlaceCreateRequestModel();
		model.addAttribute("placeCreateRequestModel", createRequestModel);
		model.addAttribute("places", this.placeService.findAllPlaces());
		return "components/place-create";
	}

	@PostMapping("/place-create")
	public String register(Model model, PlaceCreateRequestModel requestModel) {
		if (!requestModel.getName().isEmpty()) {
			System.out.println(requestModel.getName().toLowerCase());
			if (this.placeService.register(requestModel.getName().toLowerCase())) {
				return "redirect:/allPlaces";
			}
		}
		return register(model);
	}
	
	@GetMapping("/place-delete")
	public String delete(Model model) {
		model.addAttribute("title", "Изтриване населено място");
		model.addAttribute("places", this.placeService.findAllPlaces());
		return "components/place-delete";
	}

	@PostMapping("/place-delete")
	@ResponseBody
	public String delete(@RequestParam("id") String id, Model model) {
		this.placeService.delete(Long.parseLong(id));
		return "redirect:/allPlaces";
	}
}
