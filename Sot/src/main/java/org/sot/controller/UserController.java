/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jordan
 */
@Controller
public class UserController {

	@GetMapping("/login")
	public ModelAndView login(ModelAndView view) {
		view.addObject("title", "Влез");
		view.setViewName("/user/login");
		return view;
	}
}
