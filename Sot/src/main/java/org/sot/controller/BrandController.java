package org.sot.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sot.models.Entity.Brand;
import org.sot.models.requests.BrandCreateRequestModel;
import org.sot.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/brand-register")
	public String register(Model model) {
		model.addAttribute("title", "Марка");
		BrandCreateRequestModel brandCreateRequestModel = new BrandCreateRequestModel();
		model.addAttribute("brandCreateRequestModel", brandCreateRequestModel);
		model.addAttribute("brands", this.brandService.findAllBrands());
		return "components/brand-register";
	}

	@PostMapping("/brand-register")
	public String register(Model model, BrandCreateRequestModel requestModel) {
		if (!requestModel.getName().isEmpty()) {
			this.brandService.register(requestModel.getName().toLowerCase());
		}
		return register(model);
	}

	@PostMapping("/brand-delete")
	@ResponseBody
	public String delete(@RequestParam("id") String id, Model model) {
		boolean isDeleted = this.brandService.delete(Long.parseLong(id));
		return null;
	}
}
