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
//,sequenceName="TYPE_PATIENTseq"
@Entity
@Table(name="type")
public class Type implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
	@Column(name = "object")
	private String object;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="patient_index", updatable=false,insertable=false,nullable=false)
		private Patient patientIndex;
		public Type() {
			super();
		}
		public Type(String object, Date startDate, Date endDate) {
			super();
			this.object = object;
			this.startDate = startDate;
			this.endDate = endDate;
		}
		public String getObject() {
			return object;
		}
		public void setObject(String object) {
			this.object = object;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
	
}
