package org.sot.services;

import org.modelmapper.ModelMapper;
import org.sot.repositories.ControlBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jordan
 */
@Service
public class ControlBoardService {
	
	private final ControlBoardRepository cbr;
	private final ModelMapper mapper;

	@Autowired
	public ControlBoardService(ControlBoardRepository cbr, ModelMapper mapper) {
		this.cbr = cbr;
		this.mapper = mapper;
	}
}
