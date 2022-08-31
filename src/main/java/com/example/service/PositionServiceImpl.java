package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Positions;
import com.example.repository.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService {
	@Autowired
	private PositionRepository positionRepository;
	
	@Override
	public List<Positions> getPositions() {
		return positionRepository.findAll();
	}

}
