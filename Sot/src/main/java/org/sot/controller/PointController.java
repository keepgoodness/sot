package org.sot.controller;

import java.util.List;
import javax.validation.Valid;
import org.sot.exceptions.ExistingIdentifierException;
import org.sot.exceptions.ExistingPointException;
import org.sot.models.bindings.CompanyBindingModel;
import org.sot.models.bindings.PointAtrBindingModel;
import org.sot.models.bindings.PointBindingModel;
import org.sot.models.entities.Place;
import org.sot.repositories.StreetRepository;
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

    private final PlaceService placeService;
    private final PointService pointService;
    private final StreetRepository sr;

    @Autowired
    public PointController(PlaceService placeService, PointService pointService, StreetRepository sr1) {
        this.placeService = placeService;
        this.pointService = pointService;
        this.sr = sr1;
    }

    @ModelAttribute("places")
    public List<Place> getPlaces() {
        return this.placeService.findAllPlaces();
    }
	
	@ModelAttribute("allPoints")
	public String getAllPoint(){
		return this.pointService.getPointsAsJsonArray().toString();
	}

//    @GetMapping("point-create")
//    public String pointCreate(@ModelAttribute PointBindingModel pointBindingModel, Model model) {
//        model.addAttribute("title", "Създаване на обект");
//        pointBindingModel.setPlaces(placeService.findAllPlaces());
//        pointBindingModel.setBrands(brandService.findAllBrands());
//        model.addAttribute("allPoints", pointService.getPointsAsJsonArray().toString());
//        return "points/pointCreate";
//    }

//	@PostMapping("point-create")
//	public String pointCreate(Model model, @Valid @ModelAttribute PointBindingModel prm, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			return "points/pointCreate";
//		}
//		this.pointService.register(prm);
//		return "redirect:/";
//	}
    @GetMapping("/create-new")
    public String pointCreateNew(@Valid @ModelAttribute PointAtrBindingModel pointAtrBindingModel, Model model) {
        model.addAttribute("title", "Създаване на обект");
        return "points/pointCreateNew";
    }

    @PostMapping("/create-new")
    public String pointCreateNew(Model model, @Valid @ModelAttribute PointAtrBindingModel pointAtrBindingModel,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "points/pointCreateNew";
        }
		System.out.println(pointAtrBindingModel.getResponsiblePersons().get(0).getFirstName());
        try {
            pointService.registerNew(pointAtrBindingModel);
        } catch (ExistingPointException exP) {
            bindingResult.rejectValue("name", null, "Вече съществува обект с това имееее");
            return "points/pointCreateNew";
        } catch (ExistingIdentifierException exId){
            bindingResult.rejectValue("name", null, "Вече съществува обект с това ID");
            return "points/pointCreateNew";
        }
        return "redirect:/";
    }
}
