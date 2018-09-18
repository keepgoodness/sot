/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.services;

import org.sot.models.Entity.Point;
import org.sot.repositories.Pointrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jordan
 */
@Service
public class PointServiceImpl implements PointService {

	private final Pointrepository pointrepository;

	@Autowired
	public PointServiceImpl(Pointrepository pointrepository) {
		this.pointrepository = pointrepository;
	}

	@Override
	public boolean register(Point point) {
		Long id = pointrepository.save(point).getId();
		if (id == null) {
			return false;
		}
		return true;
	}

}
