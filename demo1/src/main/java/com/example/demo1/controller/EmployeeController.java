package com.example.demo1.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;

import com.example.demo1.entity.DesignationEntity;
import com.example.demo1.entity.EmployeeEntity;
import com.example.demo1.service.DesignationService;
import com.example.demo1.service.EmployeeService;
import com.example.demo1.validator.DesignationValidator;

@RestController
public class EmployeeController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DesignationService designationService;
	
	@RequestMapping(value = "/v1/employees/{id}")
	public ResponseEntity<List<EmployeeEntity>> getEmployee(@PathVariable Long id) {
		LOGGER.info("employee id "+id);
		List<EmployeeEntity> empList = employeeService.findByEmpId(id);
		return new ResponseEntity<List<EmployeeEntity>>(empList, HttpStatus.OK);
	}	
	

	@RequestMapping(value = "/v1/employees/", method = RequestMethod.POST)
	public ResponseEntity<EmployeeEntity> create(@RequestBody @Valid EmployeeEntity emp, UriComponentsBuilder builder) {
		LOGGER.info("Creating employee id " + emp.getEmpid());
		if(DesignationValidator.validate(emp, employeeService, designationService)) {
			employeeService.saveUser(emp);
			LOGGER.info("after save");
        		HttpHeaders headers = new HttpHeaders();
            		headers.setLocation(builder.path("/v1/employees/{id}").buildAndExpand(emp.getEmpid()).toUri());
            		return new ResponseEntity<EmployeeEntity>(headers, HttpStatus.CREATED);	
		} else {
			return new ResponseEntity<EmployeeEntity>(HttpStatus.CONFLICT);
		}

		
    }
    
}
