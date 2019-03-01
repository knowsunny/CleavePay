package com.sunny.cleavepay.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sunny.cleavepay.model.CPTransaction;

public interface ICPTransactionDao extends MongoRepository<CPTransaction, String> {
	

}
