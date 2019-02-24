package com.sunny.cleavepay.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sunny.cleavepay.model.CPGroup;

public interface ICPGroupDao extends MongoRepository<CPGroup, Integer> {
	boolean existsByGroupName(String groupName);
}
