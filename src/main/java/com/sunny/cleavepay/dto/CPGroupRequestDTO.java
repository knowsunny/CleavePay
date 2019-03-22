package com.sunny.cleavepay.dto;

import java.util.List;

import org.bson.types.ObjectId;

public class CPGroupRequestDTO {
		String groupName;
		List<String> groupMember; 
		String createdBy;
		int groupTotal;
		public CPGroupRequestDTO() {};
		public CPGroupRequestDTO(String groupName, List<String> groupMember, String createdBy, int groupTotal) {
			
			this.groupName = groupName;
			this.groupMember = groupMember;
			this.createdBy = createdBy;
			this.groupTotal = groupTotal;
		}
		public String getGroupName() {
			return groupName;
		}
		public void setGroupName(String groupName) {
			this.groupName = groupName;
		}
		public List<String> getGroupMember() {
			return groupMember;
		}
		public void setGroupMember(List<String> groupMember) {
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
}
