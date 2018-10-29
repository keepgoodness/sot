package org.sot.services.implementations;

import java.util.List;
import java.util.Optional;
import org.sot.models.bindings.UnitBinding;
import org.sot.models.entities.Unit;
import org.sot.repositories.UnitRepository;
import org.sot.services.interfaces.UnitService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Jordan
 */
public class UnitServiceImp implements UnitService {

	private final UnitRepository unitRepository;

	@Autowired
	public UnitServiceImp(UnitRepository unitRepository) {
		this.unitRepository = unitRepository;
	}

	@Override
	public boolean register(UnitBinding unitBinding) {
		String nameNormalize = normalize(unitBinding.getName());
		Unit fb = this.unitRepository.findFirstByName(nameNormalize);
		if (fb != null) {
			return false;
		}
		Unit unit = new Unit();
		unit.setName(nameNormalize);
		Unit u = this.unitRepository.save(unit);
		if (u == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<Unit> findAllUnits() {
		this.unitRepository.findAll().forEach(u -> u.setName(capitalize(u.getName())));
		return this.unitRepository.findAll();
	}

	@Override
	public boolean delete(String idString) {
		Long id = Long.parseLong(idString);
		this.unitRepository.deleteById(id);
		Optional<Unit> u = this.unitRepository.findById(id);
		if (u.isPresent()) {
			return false;
		}
		return true;
	}

	public static String capitalize(String x) {
		return x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
	}

	public String normalize(String x) {
		return x.toLowerCase();
	}

}
