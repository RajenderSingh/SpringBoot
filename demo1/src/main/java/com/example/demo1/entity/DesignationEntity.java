package com.example.demo1.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="desig")
public class DesignationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	private Long desigid;	
	private String designation;
	private Long parentdesigid;
	
	public DesignationEntity(Long desigid, String designation, Long parentdesigid) {
		super();
		this.desigid = desigid;
		this.designation = designation;
		this.parentdesigid = parentdesigid;
	}
	
	public DesignationEntity() {
		super();
	}
	
	public Long getDesigid() {
		return desigid;
	}
	public void setDesigid(Long desigid) {
		this.desigid = desigid;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Long getParentdesigid() {
		return parentdesigid;
	}
	public void setParentdesigid(Long parentdesigid) {
		this.parentdesigid = parentdesigid;
	}
	
	
}
