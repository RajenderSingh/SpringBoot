package com.example.demo1.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NumberDTO {
	
	public NumberDTO() {
		super();
	}

	@JsonProperty("numbers")
	private List<Integer> numberLst;

	@Override
	public String toString() {
		return "NumberDTO [numberLst=" + numberLst + "]";
	}

	public List<Integer> getNumberLst() {
		return numberLst;
	}

	public NumberDTO(List<Integer> numberLst) {
		super();
		this.numberLst = numberLst;
	}

	public void setNumberLst(List<Integer> numberLst) {
		this.numberLst = numberLst;
	}
	
}
