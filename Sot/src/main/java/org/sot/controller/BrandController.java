package org.sot.controller;

import javax.validation.Valid;
import org.sot.models.bindings.BrandBindingModel;
import org.sot.services.BrandService;
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
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    public String allBrands(Model model) {
        model.addAttribute("title", "Всички марки");
        model.addAttribute("brands", this.brandService.findAllBrands());
        return "components/brands";
    }

    @GetMapping("/brand-create")
    public String register(Model model, @ModelAttribute BrandBindingModel brandBindingModel) {
        model.addAttribute("title", "Марка");
        model.addAttribute("brands", this.brandService.findAllBrands());
        return "components/brand-create";
    }

    @PostMapping("/brand-create")
    public String register(Model model, @Valid @ModelAttribute BrandBindingModel brandBindingModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return register(model, brandBindingModel);
        }
        this.brandService.register(brandBindingModel);
        return "redirect:/brands";
    }

    @PostMapping("/brand-delete")
    public ResponseEntity<Object> delete(@RequestParam("id") String id) {
        this.brandService.delete(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }
}
