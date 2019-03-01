package com.sunny.cleavepay.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sunny.cleavepay.dao.ICPGroupDao;
import com.sunny.cleavepay.dao.ICleavepayDao;
import com.sunny.cleavepay.model.CPGroup;

@Service("groupDetailsService")
public class CPGroupServices {

	private final ICPGroupDao groupDAO;
	private final ICleavepayDao cleavepayuserDAO;

	@Autowired
	CPGroupServices(ICPGroupDao groupDao, ICleavepayDao cleavepayuserDAO) {
		this.groupDAO = groupDao;
		this.cleavepayuserDAO = cleavepayuserDAO;
	}

	public boolean createCPGroup(CPGroup cpgroup) {
		groupDAO.save(cpgroup);
		return true;

	}

	public List<CPGroup> getAllUserGroups(String mobileNumber, int groupPageNumber) {
		ObjectId cpUserObjectId = cleavepayuserDAO.findByMobileNumber(mobileNumber).getUserId();
		List<CPGroup> userGroup = groupDAO.findByGroupMember(cpUserObjectId,
				new PageRequest(groupPageNumber, 7, new Sort(Sort.Direction.DESC, "groupTotal")));
		return userGroup;
	}
}
