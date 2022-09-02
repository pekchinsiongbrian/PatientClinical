package com.dxc.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PatientData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first name")
	private String fname;
	
	@Column(name="last name")
	private String lname;
	
	@Column(name="age")
	private int age;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="patient id")
	@OrderColumn(name="type")
	private List<ClinicalData> clinicalData;
	
	public int getId() {
		return id;
	}
	
	public String getFname() {
		return fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public List<ClinicalData> getClinicalData() {
		return clinicalData;
	}

	public void setClinicalData(List<ClinicalData> clinicalData) {
		this.clinicalData = clinicalData;
	}
}
