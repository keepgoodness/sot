/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.services.interfaces;

import java.util.List;
import org.sot.models.bindings.UnitBinding;
import org.sot.models.entities.Unit;

/**
 *
 * @author Jordan
 */
public interface UnitService {
	
	public boolean register(UnitBinding unitBinding);

	public List<Unit> findAllUnits();

	public boolean delete(String id);
}
