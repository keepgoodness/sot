package org.sot.controller;

import org.sot.models.requests.BrandCreateRequestModel;
import org.sot.services.BrandService;
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
public class BrandController {

	private final BrandService brandService;

	@Autowired
	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}

	@GetMapping("/allBrands")
	public String allBrands(Model model) {
		model.addAttribute("title", "Всички марки");
		model.addAttribute("allBrands", this.brandService.findAllBrands());
		return "components/allBrands";
	}

	@GetMapping("/brand-create")
	public String register(Model model) {
		model.addAttribute("title", "Марка");
		BrandCreateRequestModel brandCreateRequestModel = new BrandCreateRequestModel();
		model.addAttribute("brandCreateRequestModel", brandCreateRequestModel);
		model.addAttribute("brands", this.brandService.findAllBrands());
		return "components/brand-create";
	}

	@PostMapping("/brand-create")
	public String register(Model model, BrandCreateRequestModel requestModel) {
		if (!requestModel.getName().isEmpty()) {
			if (this.brandService.register(requestModel.getName().toLowerCase())) {
				return "redirect:/allBrands";
			}
		}
		return register(model);
	}

	@GetMapping("/brand-delete")
	public String delete(Model model) {
		model.addAttribute("title", "Изтриване марка");
		model.addAttribute("brands", this.brandService.findAllBrands());
		return "components/brand-delete";
	}

	@PostMapping("/brand-delete")
	@ResponseBody
	public String delete(@RequestParam("id") String id, Model model) {
		this.brandService.delete(Long.parseLong(id));
		return "redirect:/allBrands";
	}
}
