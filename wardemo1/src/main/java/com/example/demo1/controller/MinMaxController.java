package com.example.demo1.controller;

import java.util.Collections;
import java.util.Comparator;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.domain.NumberDTO;
import com.example.demo1.domain.Result;
/**
 * Min-Max Challenge 
Create a rest service with a spring boot application that will expose one endpoint with a list of numbers as a parameter, and the response will be composed by 2 attributes : max and min . JSON format.
Given “N” positive integers, find the minimum and maximum values that can be calculated by summing exactly N-1 of the N integers. 
Example 
Our initial numbers are 5,4,3,1,2, 5 , 2 ,3 .

 * @author Rajender_Singh02
 *
 */

@RestController
@RequestMapping("/challenge")
public class MinMaxController {

	@RequestMapping(method = RequestMethod.POST, produces={"application/json"}, consumes="application/json")
	public Result findMinMax(@RequestBody NumberDTO numberDTO) {
		
		Integer max = getMax(numberDTO);
		Integer min = getMin(numberDTO);
		return new Result(max, min);
	}
	
	private Integer getMax(NumberDTO numberDTO){
		return numberDTO.getNumberLst().stream().max(Comparator.comparing(i -> i)).get();
	}
	
	private Integer getMin(NumberDTO numberDTO){
		return numberDTO.getNumberLst().stream().min(Comparator.comparing(i -> i)).get();
	}
}
