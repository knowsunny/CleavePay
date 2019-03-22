package com.sunny.cleavepay.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sunny.cleavepay.dao.ICPGroupDao;
import com.sunny.cleavepay.dao.ICleavepayDao;
import com.sunny.cleavepay.dto.CPGroupRequestDTO;
import com.sunny.cleavepay.model.CPGroup;
import com.sunny.cleavepay.model.CPUser;

@Service("groupDetailsService")
public class CPGroupServices {

	private final ICPGroupDao groupDAO;
	private final ICleavepayDao cleavepayuserDAO;

	@Autowired
	CPGroupServices(ICPGroupDao groupDao, ICleavepayDao cleavepayuserDAO) {
		this.groupDAO = groupDao;
		this.cleavepayuserDAO = cleavepayuserDAO;
	}

	public boolean createCPGroup(CPGroupRequestDTO cpgrouprequestDTO) {
		CPGroup cpgroup=transformCPGroupRqstToCPGroup(cpgrouprequestDTO);
		groupDAO.save(cpgroup);
		return true;

	}

	private CPGroup transformCPGroupRqstToCPGroup(CPGroupRequestDTO cpgrouprequestDTO) {
		CPGroup cpgroup=new CPGroup();
		cpgroup.setCreatedBy(cpgrouprequestDTO.getCreatedBy());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		cpgroup.setDate(dtf.format(now));
		List<String> membersMobileNumber=cpgrouprequestDTO.getGroupMember();
		List<ObjectId> member = new ArrayList();
		for(int i=0;i<membersMobileNumber.size();i++) {
			CPUser cpuser=new CPUser();
			String mobileNumber=membersMobileNumber.get(i);
			cpuser=cleavepayuserDAO.findByMobileNumber(mobileNumber);
			ObjectId memberId=cpuser.getUserId();
			member.add(memberId);
		}
		cpgroup.setGroupMember(member);
		cpgroup.setGroupName(cpgrouprequestDTO.getGroupName());
		cpgroup.setGroupTotal(0);
		return cpgroup;
	}

	public List<CPGroupRequestDTO> getAllUserGroups(String mobileNumber, int groupPageNumber) {
		ObjectId cpUserObjectId = cleavepayuserDAO.findByMobileNumber(mobileNumber).getUserId();
		List<CPGroup> userGroup = groupDAO.findByGroupMember(cpUserObjectId,
				new PageRequest(groupPageNumber, 7, new Sort(Sort.Direction.DESC, "groupTotal")));
		CPGroupRequestDTO cpgrouprequest=new CPGroupRequestDTO();
		List<CPGroupRequestDTO> cpGroupList=new ArrayList<>();
		for(CPGroup cpgroup:userGroup) {
		cpgrouprequest=tranform(cpgroup);
		cpGroupList.add(cpgrouprequest);
		}
		return cpGroupList;
	}

	private CPGroupRequestDTO tranform(CPGroup cpgroup) {
		CPGroupRequestDTO cpgroupReqDto=new CPGroupRequestDTO();
		cpgroupReqDto.setGroupName(cpgroup.getGroupName());
		List<ObjectId> membersObjectId=cpgroup.getGroupMember();
		List<String> memberMobileNumber = new ArrayList<>();
		for(int i=0;i<membersObjectId.size();i++) {
			CPUser cpuser=new CPUser();
			ObjectId cpuserObjId=membersObjectId.get(i);
			cpuser=cleavepayuserDAO.findByUserId(cpuserObjId);
			String memberId=cpuser.getMobileNumber();
			memberMobileNumber.add(memberId);
		}
		cpgroupReqDto.setGroupMember(memberMobileNumber);
		cpgroupReqDto.setCreatedBy(cpgroup.getCreatedBy());
		cpgroupReqDto.setGroupTotal(cpgroup.getGroupTotal());
		return cpgroupReqDto;
	}
}
