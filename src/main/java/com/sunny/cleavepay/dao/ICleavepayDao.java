package com.sunny.cleavepay.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sunny.cleavepay.model.CPUser;
@Repository
public interface ICleavepayDao extends MongoRepository<CPUser, Integer> {
	CPUser findByMobileNumber(String mobileNumber);
	boolean existsByMobileNumber(String mobileNumber);


}
