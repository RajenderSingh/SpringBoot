package com.example.demo1.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="emp")
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	private Long empid;	
	private String empname;
	private Long mgrid;
	private Long desigid;
	
	public EmployeeEntity() {
		super();		
	}
	
	public EmployeeEntity(Long empid, String empname, Long mgrid, Long desigid) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.mgrid = mgrid;
		this.desigid = desigid;
	}
	
	public Long getEmpid() {
		return empid;
	}
	public void setEmpid(Long empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Long getMgrid() {
		return mgrid;
	}
	public void setMgrid(Long mgrid) {
		this.mgrid = mgrid;
	}
	public Long getDesigid() {
		return desigid;
	}
	public void setDesigid(Long desigid) {
		this.desigid = desigid;
	}	
}
