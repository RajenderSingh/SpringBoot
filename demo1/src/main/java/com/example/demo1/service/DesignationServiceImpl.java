package com.example.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.DesignationEntity;
import com.example.demo1.repo.DesignationRepository;

@Service
public class DesignationServiceImpl implements DesignationService {
	@Autowired
	private DesignationRepository designationRepository;
	
	@Override
	public DesignationEntity findById(Long id) {
		return designationRepository.findOne(id);
	}
	
}
