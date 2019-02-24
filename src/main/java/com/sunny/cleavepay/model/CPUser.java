package com.sunny.cleavepay.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="CPuser")
public class CPUser {
	private ObjectId userId; 
	private String username;
	private String mobileNumber;
	private String password;
	private String emailId;
	private boolean isAuthenticatedUser;
	public CPUser() {};
	public CPUser(ObjectId userId, String username, String mobileNumber, String emailId, String password) {
		this.username=username;
		this.mobileNumber=mobileNumber;
		this.emailId=emailId;
		this.password=password;
	}
	public ObjectId getUserId() {
		return userId;
	}
	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public boolean isAuthenticatedUser() {
		return isAuthenticatedUser;
	}
	public void setAuthenticatedUser(boolean isAuthenticatedUser) {
		this.isAuthenticatedUser = isAuthenticatedUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
