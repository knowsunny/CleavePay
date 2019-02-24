package com.sunny.cleavepay.service;


import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sunny.cleavepay.dao.ICPGroupDao;
import com.sunny.cleavepay.dao.ICleavepayDao;
import com.sunny.cleavepay.model.CPGroup;
import com.sunny.cleavepay.model.CPUser;
@Service("userDetailsService")
public class CPUserService implements UserDetailsService  {
	private static final Logger LOGGER = LoggerFactory.getLogger(CPUserService.class);

    private final ICleavepayDao cleavepaydao;
    private final ICPGroupDao groupDAO; 

    @Autowired
    CPUserService(ICleavepayDao cleavepaydao, ICPGroupDao groupDao) {
        this.cleavepaydao = cleavepaydao;
        this.groupDAO=groupDao;
    }
	
	public String createCPUser(CPUser user) {
		if(!cleavepaydao.existsByMobileNumber(user.getMobileNumber())) {
		cleavepaydao.save(user);
		return "user created successful";
		}
		return "user already exist";
	}

	@Override
	public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException {
		CPUser user = cleavepaydao.findByMobileNumber(mobileNumber);
System.out.println(user.getMobileNumber()+" "+user.getPassword());
	    if(user == null) {
	      throw new UsernameNotFoundException("User not found");
	    }

	    List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

	    return new User(user.getMobileNumber(), user.getPassword(), authorities);
	  }
	public boolean createCPGroup(CPGroup cpgroup) {
		boolean isUser = cleavepaydao.existsByMobileNumber(cpgroup.getCreatedBy());
		boolean isGroupExist=groupDAO.existsByGroupName(cpgroup.getGroupName());
		if(isUser && isGroupExist) {
			return false;
		}else {
			groupDAO.save(cpgroup);
		}
		return true;
		
	}
	}

