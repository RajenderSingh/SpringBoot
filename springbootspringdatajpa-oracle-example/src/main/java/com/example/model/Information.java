package com.example.model;

import java.util.Date;

public class Information {    
 
    Long ID;
    String CODE;
    String COUNTRY;  
    Date date;
  
	public Information(Long iD, String cODE, String cOUNTRY, Date date) {
		super();
		ID = iD;
		CODE = cODE;
		COUNTRY = cOUNTRY;
		this.date = date;
	}

	public Information() {
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + ID +
                ", code='" + CODE + '\'' +
                ", country='" + COUNTRY + '\'' +
                ", date=" + date +
                '}';
    }

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getCOUNTRY() {
		return COUNTRY;
	}

	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
