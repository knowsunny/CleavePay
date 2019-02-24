package com.sunny.cleavepay.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CP_Transaction")
public class CPTransaction {
	ObjectId cptransactionId;
	String transactionName;
	String transactionType;
	ObjectId cpgroupId;
	List<ObjectId> cpuserInvolved;
	public CPTransaction() {};
	public CPTransaction(ObjectId cptransactionId, String transactionName, String transactionType, ObjectId cpgroupId,
			List<ObjectId> cpuserInvolved) {
		this.cptransactionId = cptransactionId;
		this.transactionName = transactionName;
		this.transactionType = transactionType;
		this.cpgroupId = cpgroupId;
		this.cpuserInvolved = cpuserInvolved;
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
	public List<ObjectId> getCpuserInvolved() {
		return cpuserInvolved;
	}
	public void setCpuserInvolved(List<ObjectId> cpuserInvolved) {
		this.cpuserInvolved = cpuserInvolved;
	}

}
