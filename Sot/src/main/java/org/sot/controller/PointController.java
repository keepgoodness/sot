package org.sot.controller;

import java.util.List;
import javax.validation.Valid;
import org.sot.models.Entity.Address;
import org.sot.models.Entity.Brand;
import org.sot.models.Entity.Place;
import org.sot.models.Entity.Point;
import org.sot.models.requests.PointRequestModel;
import org.sot.services.AddressService;
import org.sot.services.BrandService;
import org.sot.services.PlaceService;
import org.sot.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	private final AddressService addressService;
	private final PointService pointService;

	@Autowired
	public PointController(BrandService brandService, PlaceService placeService, AddressService addressService, PointService pointService) {
		this.brandService = brandService;
		this.placeService = placeService;
		this.addressService = addressService;
		this.pointService = pointService;
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
	public String pointCreate(Model model, @Valid PointRequestModel prm, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			Address address = prm.getAddress();
			if (this.addressService.create(address)) {
				Point point = new Point();
				point.setName(prm.getPointName());
				point.setIdentifier(prm.getPointIdentifier());
				point.setPlace(prm.getPlace());
				point.setAddress(address);
				if (this.pointService.register(point)) {
					return "redirect:/";
				}
			}
		}
		model.addAttribute("pointRequestModel", prm);
		return pointCreate(model);
	}
}
