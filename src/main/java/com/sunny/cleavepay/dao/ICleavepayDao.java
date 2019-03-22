package com.sunny.cleavepay.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sunny.cleavepay.model.CPUser;
@Repository
public interface ICleavepayDao extends MongoRepository<CPUser, Integer> {
	CPUser findByMobileNumber(String mobileNumber);
	boolean existsByMobileNumber(String mobileNumber);
	boolean existsByEmailId(String emailId);
	@Query(value = "{ 'mobileNumber' : ?0 }")
	ObjectId findObjectIdByMobileNumber(String mobileNumber);
	public CPUser findByUserId(ObjectId userId);


}
