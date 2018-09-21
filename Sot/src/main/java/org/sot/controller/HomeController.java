package org.sot.controller;

import java.util.ArrayList;
import java.util.List;
import org.sot.models.Entity.Point;
import org.sot.models.requests.PointRequestModel;
import org.sot.repositories.Pointrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Jordan
 */
@Controller
public class HomeController {

	private final Pointrepository pointrepository;

	@Autowired
	public HomeController(Pointrepository pointrepository) {
		this.pointrepository = pointrepository;
	}

	@GetMapping("/")
	public String home(Model model) {
		PointRequestModel pointModel = new PointRequestModel();
		model.addAttribute("title", "Карти");
		
		ArrayList<String> listOfString = new ArrayList<>();
		
		List<Point> allPoints = this.pointrepository.findAll();
		for (int i = 0; i < allPoints.size(); i++) {
			listOfString.add(allPoints.get(i).toString());
			System.out.println(allPoints.get(i).toString());
		}
		model.addAttribute("allPoints", listOfString);
		model.addAttribute("pointRequestModel", pointModel);
		return "index";
	}

}
