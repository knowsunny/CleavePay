package com.sunny.cleavepay.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CP_Transaction")
public class CPTransaction {
	private ObjectId cptransactionId;
	private String transactionName;
	private String transactionType;
	private ObjectId cpgroupId;
	private List<UserToUserTransaction> cpuserInvolved;
	private String transactionDateTime;

	public CPTransaction() {
	};

	public CPTransaction(ObjectId cptransactionId, String transactionName, String transactionType, ObjectId cpgroupId,
			List<UserToUserTransaction> cpuserInvolved, String transactionDateTime) {
		this.cptransactionId = cptransactionId;
		this.transactionName = transactionName;
		this.transactionType = transactionType;
		this.cpgroupId = cpgroupId;
		this.cpuserInvolved = cpuserInvolved;
		this.transactionDateTime = transactionDateTime;
	}

	public ObjectId getCptransactionId() {
		return cptransactionId;
	}

	public void setCptransactionId(ObjectId cptransactionId) {
		this.cptransactionId = cptransactionId;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public ObjectId getCpgroupId() {
		return cpgroupId;
	}

	public void setCpgroupId(ObjectId cpgroupId) {
		this.cpgroupId = cpgroupId;
	}

	public List<UserToUserTransaction> getCpuserInvolved() {
		return cpuserInvolved;
	}

	public void setCpuserInvolved(List<UserToUserTransaction> cpuserInvolved) {
		this.cpuserInvolved = cpuserInvolved;
	}

	public String getCreationDate() {
		return transactionDateTime;
	}

	public void setCreationDate(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

}
