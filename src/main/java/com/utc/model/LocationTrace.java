package com.utc.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//,sequenceName="LOCATION_PATIENTseq"
/**
 * @author HAI
 *
 */
/**
 * @author HAI
 *
 */
/**
 * @author HAI
 *
 */
@Entity
@Table(name = "locationtrace")
public class LocationTrace implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String location;
	private Date time;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_index", updatable = false, insertable = false, nullable = false)
	private Patient patientIndex;
	@Column(name = "contact_person")
	private String contactPerson;
	
	private int contactPersonID;
	
	public LocationTrace() {
		super();
	}

	public LocationTrace(String location, Date time, String contactPerson, int contactPersonID) {
		super();
		this.location = location;
		this.time = time;
		this.contactPerson = contactPerson;
		this.contactPersonID = contactPersonID;
	}

	

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public int getContactPersonID() {
		return contactPersonID;
	}

	public void setContactPersonID(int contactPersonID) {
		this.contactPersonID = contactPersonID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
