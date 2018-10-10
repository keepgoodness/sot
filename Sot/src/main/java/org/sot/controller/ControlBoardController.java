package org.sot.controller;

import org.sot.models.bindings.PlaceCreateBindingModel;
import org.sot.repositories.ControlBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Jordan
 */
@Controller
public class ControlBoardController {
	
	private final ControlBoardRepository boardRepository;

	@Autowired
	public ControlBoardController(ControlBoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	@GetMapping("/control-boards")
	public String allControlBoards(Model model){
		model.addAttribute("title", "Контролни платки");
		return "components/control-boards";
	}
	
	@GetMapping("/control-board-create")
	public String create(Model model) {
		model.addAttribute("title", "Контролна платка");
		return "components/control-boards-create";
	}
}
