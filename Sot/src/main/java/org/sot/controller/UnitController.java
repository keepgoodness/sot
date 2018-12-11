//package org.sot.controller;
//
//import org.sot.services.interfaces.UnitService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
///**
// *
// * @author Jordan
// */
//@Controller
//public class UnitController {
//
//	private final UnitService unitService;
//	
//	@Autowired
//	public UnitController(UnitService unitService) {
//		this.unitService = unitService;
//	}
//
//	@GetMapping("/units")
//	public String allUnits(Model model) {
//		model.addAttribute("title", "Компоненти");
//		model.addAttribute("units", this.unitService.findAllUnits());
//		return "components/units";
//	}
//}
