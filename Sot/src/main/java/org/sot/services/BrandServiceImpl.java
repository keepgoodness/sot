package org.sot.services;

import java.util.List;
import java.util.Optional;
import org.apache.coyote.Response;
import org.sot.models.bindings.BrandBindingModel;
import org.sot.models.entities.Brand;
import org.sot.models.entities.ControlBoard;
import org.sot.repositories.BrandRepository;
import org.sot.repositories.ControlBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jordan
 */
@Service
public class BrandServiceImpl implements BrandService {

	private final BrandRepository brandRepository;
	private final ControlBoardService boardService;
	private final SensorService sensorService;

	@Autowired
	public BrandServiceImpl(BrandRepository brandRepository, ControlBoardService boardService, SensorService sensorService) {
		this.brandRepository = brandRepository;
		this.boardService = boardService;
		this.sensorService = sensorService;
	}

	@Override
	public boolean register(BrandBindingModel bindingModel) {
		String nameNormalize = normalize(bindingModel.getName());
		Brand fb = this.brandRepository.findFirstByName(nameNormalize);
		if (fb != null) {
			return false;
		}
		Brand brand = new Brand();
		brand.setName(nameNormalize);
		Brand b = this.brandRepository.save(brand);
		if (b == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<Brand> findAllBrands() {
		this.brandRepository.findAll().forEach(b -> b.setName(capitalize(b.getName())));
		return this.brandRepository.findAll();
	}

	public static String capitalize(String x) {
		return x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
	}

	public String normalize(String x) {
		return x.toLowerCase();
	}

	@Override
	public ResponseEntity<String> delete(String idString) {
		int countBoards = boardService.findAllByBrandId(idString).size();
		int countSensors = sensorService.findAllByBrandId(idString).size();
		boolean isDelAllowed = true;
		StringBuilder message = new StringBuilder("Не може да изтриете, защото с тази марка има създадени: ");
		HttpStatus httpStatus;

		if (countBoards > 0) {
			message.append(countBoards + " брой/я контролни платки, ");
			isDelAllowed = false;
		}
		if (countSensors > 0) {
			message.append(countSensors + " брой/я датчици");
			isDelAllowed = false;
		}
		if (isDelAllowed) {
			this.brandRepository.deleteById(Long.parseLong(idString));
			message.setLength(0);
			httpStatus = httpStatus = HttpStatus.OK;
		} else {
			httpStatus = HttpStatus.CONFLICT;
		}
		return new ResponseEntity<String>(message.toString(), httpStatus);
	}

}
