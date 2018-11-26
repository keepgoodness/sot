package org.sot.controller;

import java.util.List;
import javax.validation.Valid;
import org.sot.models.bindings.PointAtrBindingModel;
import org.sot.models.bindings.PointBindingModel;
import org.sot.models.entities.Address;
import org.sot.models.entities.Place;
import org.sot.models.entities.Point;
import org.sot.repositories.StreetRepository;
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
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jordan
 */
@Controller
@RequestMapping("/points")
public class PointController {

	private final BrandService brandService;
	private final PlaceService placeService;
	private final PointService pointService;
	private final StreetRepository sr;

	@Autowired
	public PointController(BrandService brandService, PlaceService placeService, PointService pointService, StreetRepository sr1) {
		this.brandService = brandService;
		this.placeService = placeService;
		this.pointService = pointService;
		this.sr = sr1;
	}
	
	@ModelAttribute("places")
	public List<Place> getPlaces(){
		return this.placeService.findAllPlaces();
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
        
        @GetMapping("/create-new")
	public String pointCreateNew(@ModelAttribute PointAtrBindingModel pointAtrBindingModel, Model model) {
		model.addAttribute("title", "Създаване на обект");
		model.addAttribute("allPoints", pointService.getPointsAsJsonArray().toString());
		return "points/pointCreateNew";
	}
        
        @PostMapping("/create-new")
	public String pointCreateNew(Model model, @Valid @ModelAttribute PointAtrBindingModel pointAtrBindingModel, BindingResult bindingResult) {
			Point p = pointAtrBindingModel.getPoint();
//			System.out.println("Id: " + p.getIdentifier());
//			System.out.println("name: " + p.getName());
//			Address pAddress = p.getAddress();
//			
//			System.out.println("pAddress.place.name : " + pAddress.getPlace().getName());
//			System.out.println("pAddress.street.name : " + pAddress.getStreet().getName());
//			System.out.println("pAddress.number : " + pAddress.getNumber());
//			System.out.println("pAddress.entrance : " + pAddress.getEntrance());
//			System.out.println("pAddress.floor : " + pAddress.getFloor());
//			System.out.println("pAddress.apartment :" + pAddress.getApartment());
//			System.out.println("point.ServiceStatus : " + p.isHasSse());
//			System.out.println("point.ServiceStatus : " + p.isHasVideo());
		if (bindingResult.hasErrors()) {
			return "points/pointCreateNew";
		}
//		this.pointService.register(pointAtrBindingModel);
		return "redirect:/";
	}
}
