package org.sot.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.sot.models.bindings.ControlBoardBindModel;
import org.sot.models.entities.ControlBoard;
import org.sot.repositories.ControlBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jordan
 */
@Service
public class ControlBoardService {

	private final ControlBoardRepository cbRepo;
	private final ModelMapper mapper;

	@Autowired
	public ControlBoardService(ControlBoardRepository cbr, ModelMapper mapper) {
		this.cbRepo = cbr;
		this.mapper = mapper;
	}

	public ControlBoard getControlBoardById(String id) {
		return cbRepo.getOne(Long.parseLong(id));
	}

	public List<ControlBoard> getAllBoards() {
		List<ControlBoard> list = this.cbRepo.findAll();
		list.sort(new Comparator<ControlBoard>() {
			@Override
			public int compare(ControlBoard o1, ControlBoard o2) {
				return o1.getBrand().getName().compareTo(o2.getBrand().getName());
			}
		});
		return list;
	}

	public ControlBoardBindModel fillControlBoardBindModelById(String id) {
		ControlBoard cb = cbRepo.findById(Long.parseLong(id)).get();
		return mapper.map(cb, ControlBoardBindModel.class);
	}

	public void create(ControlBoardBindModel cbbm) {
		ControlBoard maped = mapper.map(cbbm, ControlBoard.class);
		cbRepo.save(maped);
	}

	public boolean delete(Long id) {
		this.cbRepo.deleteById(id);
		return !this.cbRepo.findById(id).isPresent();
	}
}
