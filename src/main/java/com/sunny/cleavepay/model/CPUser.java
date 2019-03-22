package com.sunny.cleavepay.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "CPuser")
public class CPUser {
	@Id
	private ObjectId userId;
	private String cpUserFullName;
	private String username;
	private String mobileNumber;
	private String password;
	private String emailId;
	private boolean isAuthenticatedUser;
	private String userCreationDate;
	private String lastLoginDateTime;

	public CPUser() {
	};

	public CPUser(ObjectId userId, String username, String mobileNumber, String emailId, String password,
			String userCreationDate, String lastLoginDateTime, String cpUserFullName) {
		this.cpUserFullName=cpUserFullName;
		this.username = username;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.password = password;
		this.userCreationDate = userCreationDate;
		this.lastLoginDateTime=lastLoginDateTime;

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

	public String getUserCreationDate() {
		return userCreationDate;
	}

	public void setUserCreationDate(String userCreationDate) {
		this.userCreationDate = userCreationDate;
	}

	public String getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	public void setLastLoginDateTime(String lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}

	public String getCpUserFullName() {
		return cpUserFullName;
	}

	public void setCpUserFullName(String cpUserFullName) {
		this.cpUserFullName = cpUserFullName;
	}

}
