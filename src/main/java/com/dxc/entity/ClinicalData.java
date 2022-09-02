package com.dxc.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ClinicalData {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; // primary key
	private String componentName;
	private double componentValue;
	private Date measuredDateTime;
	
	public int getId() {
		return id;
	}
	
	public String getComponentName() {
		return componentName;
	}
	
	public double getComponentValue() {
		return componentValue;
	}
	
	public Date getMeasuredDateTime() {
		return measuredDateTime;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	
	public void setComponentValue(double componentValue) {
		this.componentValue = componentValue;
	}
	
	public void setMeasuredDateTime(Date measuredDateTime) {
		this.measuredDateTime = measuredDateTime;
	}
}
