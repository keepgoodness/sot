package org.sot.controller;

import javax.validation.Valid;
import org.sot.models.bindings.PlaceCreateBindingModel;
import org.sot.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@GetMapping("/places")
	public String allPlaces(Model model) {
		model.addAttribute("title", "Населени места");
		model.addAttribute("places", this.placeService.findAllPlaces());
		return "components/places";
	}

	@GetMapping("/place-create")
	public String register(Model model, @ModelAttribute PlaceCreateBindingModel placeCreateBindingModel) {
		model.addAttribute("title", "Населено място");
		model.addAttribute("places", this.placeService.findAllPlaces());
		return "components/place-create";
	}

	@PostMapping("/place-create")
	public String register(Model model, @Valid @ModelAttribute PlaceCreateBindingModel placeCreateBindingModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return register(model, placeCreateBindingModel);
		}
		this.placeService.register(placeCreateBindingModel.getName().toLowerCase());
		return "redirect:/places";
	}

	@PostMapping("/place-delete")
	public ResponseEntity deletePlace(@RequestParam("id") String id, Model model) {
		if (id.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		this.placeService.delete(Long.parseLong(id));
		return new ResponseEntity(HttpStatus.OK);
	}
}
