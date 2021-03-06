package com.sunny.cleavepay.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunny.cleavepay.contract.CPTransactionRequestDTO;
import com.sunny.cleavepay.dto.CPGroupRequestDTO;
import com.sunny.cleavepay.model.CPGroup;
import com.sunny.cleavepay.model.CPUser;
import com.sunny.cleavepay.service.CPGroupServices;
import com.sunny.cleavepay.service.CPTransactionService;
import com.sunny.cleavepay.service.CPUserService;


@RestController
public class CPController {
	@Autowired
	CPUserService cpuserservice;
	@Autowired
	CPGroupServices cpugroupservice;
	@Autowired
	CPTransactionService cpuTransactionservice;

	
	@PostMapping("/cleavepay/registerUser")
	public String createCPUser( @RequestBody String cpUserRequest ) throws JsonParseException, JsonMappingException, IOException{
		String isUserCreated;
		try {
		ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CPUser cpUserf=objectMapper.readValue(cpUserRequest, CPUser.class);
		isUserCreated=cpuserservice.createCPUser(cpUserf);
		}catch(Exception e) {
			return e.toString();
		}
		return isUserCreated;
	}
	
	@GetMapping("/cleavepay/cpuser/{mobileNumber}")
	public CPUser getuserdetails(@PathVariable String mobileNumber) {
		return cpuserservice.getCPuserForMobileNumber(mobileNumber);
	}
	@PostMapping("/cleavepay/group/{mobileNumber}")
	public boolean createCPGroup(@PathVariable String mobileNumber, @RequestBody String groupDetails) throws JsonParseException, JsonMappingException, IOException {
		boolean isGroupCreated=true;
		ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CPGroupRequestDTO cpGroupDTO=objectMapper.readValue(groupDetails, CPGroupRequestDTO.class);
		cpugroupservice.createCPGroup(cpGroupDTO);
		return isGroupCreated;
	}
	@GetMapping("/cleavepay/{mobileNumber}/groudetails/{pagenumber}")
	public List<CPGroupRequestDTO> getUserGroupDetails(@PathVariable("mobileNumber") String mobileNumber,@PathVariable("pagenumber") int groupPageNumber){
	List<CPGroupRequestDTO> ret = cpugroupservice.getAllUserGroups(mobileNumber,groupPageNumber);	
	return ret;
	}
	
	@PostMapping("/cleavepay/transaction/groudetails/")
	public boolean createTransaction(@RequestBody String transactionDetails) {
		return cpuTransactionservice.createTransaction(transactionDetails);
	}
	

}
