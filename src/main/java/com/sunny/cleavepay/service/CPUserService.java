package com.sunny.cleavepay.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sunny.cleavepay.dao.ICPGroupDao;
import com.sunny.cleavepay.dao.ICleavepayDao;
import com.sunny.cleavepay.model.CPGroup;
import com.sunny.cleavepay.model.CPUser;

@Service("userDetailsService")
public class CPUserService implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CPUserService.class);

	@Autowired
	private PasswordEncoder passwordEncoder;
	private final ICleavepayDao cleavepaydao;

	@Autowired
	CPUserService(ICleavepayDao cleavepaydao) {
		this.cleavepaydao = cleavepaydao;
	}

	public CPUser getCPuserForMobileNumber(String mobileNumber) {
		CPUser currentCPUser = cleavepaydao.findByMobileNumber(mobileNumber);
		return currentCPUser;
	}

	public String createCPUser(CPUser user) {
		user.setPassword(encryptPassword(user.getPassword()));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		user.setUserCreationDate(dtf.format(now));
		if (!cleavepaydao.existsByMobileNumber(user.getMobileNumber())
				&& !cleavepaydao.existsByMobileNumber(user.getEmailId())) {
			cleavepaydao.save(user);
			return "user created successful";
		} else if (cleavepaydao.existsByMobileNumber(user.getMobileNumber())
				&& cleavepaydao.existsByMobileNumber(user.getEmailId())) {
			return "Mobile number and email id already exist";
		} else if (cleavepaydao.existsByMobileNumber(user.getMobileNumber())) {
			return "mobile number already exist";
		} else {
			return "Email id already exist";
		}
	}

	private String encryptPassword(String password) {
		return passwordEncoder.encode(password);
	}

	@Override
	public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException {
		CPUser user = cleavepaydao.findByMobileNumber(mobileNumber);
		System.out.println(user.getMobileNumber() + " " + user.getPassword());
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

		return new User(user.getMobileNumber(), user.getPassword(), authorities);
	}

}
