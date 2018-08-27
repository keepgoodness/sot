package org.sot.controller;

import org.sot.models.requests.PointRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jordan
 */
@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		PointRequestModel point = new PointRequestModel();
		point.setPointName("Пицария Анджили");
		point.setPointIdentifier("1234511");
		point.setControlBoardBrand("Samsung");
		point.setControlBoardModel("s3");
		model.addAttribute("title", "Карти");
		model.addAttribute("pointRequestModel", point);
		return "index";
	}
}
