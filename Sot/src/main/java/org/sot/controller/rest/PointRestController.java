package org.sot.controller.rest;

import org.sot.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jordan
 */
@RestController
public class PointRestController {
	
	private final PointService pointService;

	@Autowired
	public PointRestController(PointService pointService) {
		this.pointService = pointService;
	}
	
	@DeleteMapping("/points/delete/{id}")
	public String deletePoint(@PathVariable String id){
		System.out.println("before:" + id);
		this.pointService.deletePoint(Long.parseLong(id));
		System.out.println("after:" + id);
		return "OK!";
	}
}
