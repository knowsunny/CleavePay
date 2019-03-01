package com.sunny.cleavepay.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunny.cleavepay.contract.CPTransactionRequestDTO;
import com.sunny.cleavepay.model.CPGroup;
import com.sunny.cleavepay.model.CPTransaction;

@Service("transactionDetailsService")
public class CPTransactionService {
	public Boolean createTransaction(String transactionDetails) {
		ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			CPTransactionRequestDTO cpGroup=objectMapper.readValue(transactionDetails, CPTransactionRequestDTO.class);
			cpGroup.getTransactionName();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

}
