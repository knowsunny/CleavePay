package com.sunny.cleavepay.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserToUserTransaction")
public class UserToUserTransaction {
	private ObjectId userToUserTransactionId;
	private ObjectId cpUserId;
	private boolean isUserDebitor;
	private int amount;
	public UserToUserTransaction(ObjectId userToUserTransactionId, ObjectId cpUserId, boolean isUserDebitor,
			int amount) {
		super();
		this.userToUserTransactionId = userToUserTransactionId;
		this.cpUserId = cpUserId;
		this.isUserDebitor = isUserDebitor;
		this.amount = amount;
	}

	public UserToUserTransaction() {}
	
	public ObjectId getUserToUserTransactionId() {
		return userToUserTransactionId;
	}
	public void setUserToUserTransactionId(ObjectId userToUserTransactionId) {
		this.userToUserTransactionId = userToUserTransactionId;
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
