package com.utc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "user")
public class User implements  Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;
		@Column(name = "user")
		private String user;
		@Column(name = "password")
		private String password;
		
		@Column(name = "addPermission")
		private boolean addPermission;
		@Column(name = "updatePermission")
		private boolean updatePermission;
		
		@Column(name = "deletePermission")
		private boolean deletePermission;
		
		public User() {
			super();
		}



		public User(String user, String password, boolean addPermission, boolean updatePermission , boolean deletePermission) {
			super();
			this.user = user;
			this.password = password;
			this.addPermission = addPermission;
			this.updatePermission = updatePermission;
			this.deletePermission = deletePermission;
		}

		

		public boolean isDeletePermission() {
			return deletePermission;
		}



		public void setDeletePermission(boolean deletePermission) {
			this.deletePermission = deletePermission;
		}



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public String getUser() {
			return user;
		}



		public void setUser(String user) {
			this.user = user;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public boolean isAddPermission() {
			return addPermission;
		}



		public void setAddPermission(boolean addPermission) {
			this.addPermission = addPermission;
		}



		public boolean isUpdatePermission() {
			return updatePermission;
		}



		public void setUpdatePermission(boolean updatePermission) {
			this.updatePermission = updatePermission;
		}



		



		
	
   
	
}
