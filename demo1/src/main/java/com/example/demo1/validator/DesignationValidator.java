package com.example.demo1.validator;

import java.util.Optional;

import com.example.demo1.entity.DesignationEntity;
import com.example.demo1.entity.EmployeeEntity;
import com.example.demo1.service.DesignationService;
import com.example.demo1.service.EmployeeService;

final public class DesignationValidator {

	public static boolean validate(EmployeeEntity emp, EmployeeService employeeService, DesignationService designationService)	{
		Optional<EmployeeEntity> empFound = Optional.ofNullable(employeeService.findById(emp.getEmpid()));
        boolean validated = false;	
        if (!empFound.isPresent()){
        	Optional<EmployeeEntity> mgrFound = Optional.ofNullable(employeeService.findById(emp.getMgrid()));
        		
        	if(mgrFound.isPresent()) {
        		//validate emp desig id exists or not
        		Optional<DesignationEntity> desig = Optional.ofNullable(designationService.findById(emp.getDesigid()));
        		//validate emp mgr desig id is proper
            	if(desig.isPresent() && desig.get().getParentdesigid() == mgrFound.get().getDesigid()) {
            		validated = true;            		
            	}
        	}        	
        }
        return validated;
	}
}
