package com.sunny.cleavepay.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Cp_group")
public class CPGroup {
	@Id
	ObjectId cpGroupId;
	String groupName;
	List<ObjectId> groupMember; 
	String createdBy;
	int groupTotal;
	String groupCreationDate;
	public CPGroup() {};
	public CPGroup(ObjectId cpGroupId, String groupName, List<ObjectId> groupMember, String createdBy, int groupTotal, String groupCreationDate) {
		this.cpGroupId=cpGroupId;
		this.groupName = groupName;
		this.groupMember = groupMember;
		this.createdBy = createdBy;
		this.groupTotal = groupTotal;
		this.groupCreationDate=groupCreationDate;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<ObjectId> getGroupMember() {
		return groupMember;
	}
	public void setGroupMember(List<ObjectId> groupMember) {
		this.groupMember = groupMember;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getGroupTotal() {
		return groupTotal;
	}
	public void setGroupTotal(int groupTotal) {
		this.groupTotal = groupTotal;
	}
	public String getDate() {
		return groupCreationDate;
	}
	public void setDate(String groupCreationDate) {
		this.groupCreationDate = groupCreationDate;
	}
	public ObjectId getCpGroupId() {
		return cpGroupId;
	}
	public void setCpGroupId(ObjectId cpGroupId) {
		this.cpGroupId = cpGroupId;
	}

}
