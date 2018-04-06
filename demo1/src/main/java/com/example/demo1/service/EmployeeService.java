package com.example.demo1.service;

import java.util.List;
import java.util.Optional;

import com.example.demo1.entity.EmployeeEntity;

public interface EmployeeService {

	List<EmployeeEntity> findByEmpId(Long id);
	
	EmployeeEntity findById(Long id);

	EmployeeEntity saveUser(EmployeeEntity emp);
}
