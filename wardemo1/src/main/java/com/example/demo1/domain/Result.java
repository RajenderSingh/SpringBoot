package com.example.demo1.domain;

public class Result {

	private Integer max;
	private Integer min;
	public Integer getMax() {
		return max;
	}
	
	public Result() {
		super();
	}

	public Result(Integer max, Integer min) {
		super();
		this.max = max;
		this.min = min;
	}

	public void setMax(Integer max) {
		this.max = max;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	
	
	
	
}
