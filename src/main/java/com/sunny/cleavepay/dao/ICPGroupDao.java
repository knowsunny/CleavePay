package com.sunny.cleavepay.dao;

import java.awt.print.Pageable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sunny.cleavepay.model.CPGroup;

public interface ICPGroupDao extends MongoRepository<CPGroup, Integer> {
	boolean existsByGroupName(String groupName);
	@Query(value = "{ 'groupMember' : ?0 }")
	public List<CPGroup> findByGroupMember(ObjectId memberObjectId,PageRequest pageable);
	
}
