package org.sot.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import javax.validation.Valid;
import org.sot.models.bindings.ControlBoardBindModel;
import org.sot.models.entities.Brand;
import org.sot.models.entities.ControlBoard;
import org.sot.repositories.BrandRepository;
import org.sot.services.ControlBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Jordan
 */
@Controller
public class ControlBoardController {

	private final BrandRepository brandRepo;
	private final ControlBoardService cbservice;

	@Autowired
	public ControlBoardController(BrandRepository brandRepo, ControlBoardService cbservice) {
		this.brandRepo = brandRepo;
		this.cbservice = cbservice;
	}

	@ModelAttribute(name = "brands")
	private List<Brand> brands() {
		List<Brand> brands = brandRepo.findAll();
		brands.forEach(b -> b.setName(b.getName().toUpperCase()));
		brands.sort(new Comparator<Brand>() {
			@Override
			public int compare(Brand o1, Brand o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return brands;
	}

	@ModelAttribute(name = "boards")
	private List<ControlBoard> boards() {
		return cbservice.getAllBoards();
	}

	@GetMapping("/board")
	public String showBoard(@RequestParam("id") String id, Model model) {
		ControlBoard cb = cbservice.getControlBoardById(id);
		model.addAttribute("board", cb);
		return "/fragments/parts :: board";
	}

	@GetMapping("/control-boards")
	public String allControlBoards(Model model) {
		model.addAttribute("title", "Контролни платки");
		return "components/control_boards";
	}

	@GetMapping("/control_board-create")
	public String controlBoardCreate(@ModelAttribute ControlBoardBindModel controlBoardBindModel, Model model) {
		model.addAttribute("title", "Добави контролна платка");
		return "components/control_board-create";
	}

//	@RequestParam("file") MultipartFile file to be added
	@PostMapping("/control_board-create")
	public String controlBoardCreate(Model model, @Valid @ModelAttribute ControlBoardBindModel controlBoardBindModel, BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors()) {
			return "components/control_board-create";
		}

		cbservice.create(controlBoardBindModel);
		return "redirect:/control-boards";
	}

	@GetMapping("/control_board-update/{id}")
	public String controlBoardUpdate(@PathVariable("id") String id, Model model) {
		ControlBoardBindModel boardBindModel = cbservice.fillControlBoardBindModelById(id);
		model.addAttribute("boardBindModel", boardBindModel);
		model.addAttribute("title", "Редактиране контролна платка");
		return "components/control_board-update";
	}

	@PostMapping("/control_board-update")
	public String sensorUpdate(Model model, @Valid @ModelAttribute ControlBoardBindModel controlBoardBindModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "components/control_board-update";
		}
		cbservice.create(controlBoardBindModel);
		return "redirect:/control-boards";
	}

	@PostMapping(value = "/control_board-delete")
	public ResponseEntity controlBoardDelete(@RequestParam("id") String id, Model model) {
		if (id.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return this.cbservice.delete(Long.parseLong(id));
	}
}
