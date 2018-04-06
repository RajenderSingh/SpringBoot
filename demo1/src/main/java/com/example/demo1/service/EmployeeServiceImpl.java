package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.EmployeeEntity;
import com.example.demo1.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeEntity> findByEmpId(Long id) {		
		return employeeRepository.findByEmpId(id);	
	}

	@Override
	public EmployeeEntity findById(Long id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public EmployeeEntity saveUser(EmployeeEntity emp) {
		return employeeRepository.save(emp);
	}

	
}
