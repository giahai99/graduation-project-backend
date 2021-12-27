package com.utc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import org.apache.log4j.Logger;
import org.hibernate.annotations.ForeignKey;

//sequenceName="PATIENTseq",
@Entity
@Table(name="patient")
public class Patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_index")
	private int patient_index;
	
	@Column(name="id")
	private int id;

	private String name;
	
	private int age;
	
	private String gender;

	private String district;
	
	private String address;
	
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="patient_index",nullable=false)
	@OrderColumn(name="type")
	@ForeignKey(name="fk_patient_type")
	private List<Type> type ;
	
	private String status;
	
	private int injectionNO;
	
	@OneToMany(cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="patient_index",nullable=false)
	@OrderColumn(name="type")
	@ForeignKey(name="fk_patient_locationtrace")
	private List<LocationTrace> locationTrace;
	
	private String image;
	
	public Patient() {
		super();
	}
	
	public Patient(int id, String name, int age, String gender,String district , String address,String status,
			  int injectionNO, String abidance,List<Type> type,List<LocationTrace> locationTrace, String image) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.district = district;
		this.address = address;
		this.type = type;
		this.status = status;
		this.injectionNO = injectionNO;
		this.locationTrace = locationTrace;
		this.image = image;
	}
	// test
	public Patient(String name, int age, String gender,String district , String address,String status,
			  int injectionNO, String abidance,List<Type> type,List<LocationTrace> locationTrace, String image) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.district = district;
		this.address = address;
		this.type = type;
		this.status = status;
		this.injectionNO = injectionNO;
		this.locationTrace = locationTrace;
		this.image = image;
	}
	
	public int getPatient_index() {
		return patient_index;
	}

	public void setPatient_index(int patient_index) {
		this.patient_index = patient_index;
	}

	public List<LocationTrace> getLocationTrace() {
		return locationTrace;
	}
	public void setLocationTrace(List<LocationTrace> locationTrace) {
		this.locationTrace = locationTrace;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Type> getType() {
		return type;
	}
	public void setType(List<Type> type) {
		this.type = type;
	}
	public int getInjectionNO() {
		return injectionNO;
	}
	public void setInjectionNO(int injectionNO) {
		this.injectionNO = injectionNO;
	}
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
}
