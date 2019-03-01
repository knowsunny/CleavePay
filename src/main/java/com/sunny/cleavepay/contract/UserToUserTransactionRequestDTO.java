package com.sunny.cleavepay.contract;

import org.bson.types.ObjectId;

public class UserToUserTransactionRequestDTO {
	private String userToUserMobileNumber;
	private ObjectId cpUserId;
	private boolean isUserDebitor;
	private int amount;
	public UserToUserTransactionRequestDTO(String userToUserMobileNumber, ObjectId cpUserId, boolean isUserDebitor,
			int amount) {
		this.userToUserMobileNumber = userToUserMobileNumber;
		this.cpUserId = cpUserId;
		this.isUserDebitor = isUserDebitor;
		this.amount = amount;
	}

	public UserToUserTransactionRequestDTO() {}
	
	public String getUserToUserTransactionId() {
		return userToUserMobileNumber;
	}
	public void setUserToUserTransactionId(String userToUserMobileNumber) {
		this.userToUserMobileNumber = userToUserMobileNumber;
	}
	
	public boolean isUserDebitor() {
		return isUserDebitor;
	}
	public void setUserDebitor(boolean isUserDebitor) {
		this.isUserDebitor = isUserDebitor;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ObjectId getCpUserId() {
		return cpUserId;
	}

	public void setCpUserId(ObjectId cpUserId) {
		this.cpUserId = cpUserId;
	}
	
}
