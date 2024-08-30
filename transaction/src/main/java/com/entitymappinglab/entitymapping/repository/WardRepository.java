package com.entitymappinglab.entitymapping.repository;

import com.entitymappinglab.entitymapping.modules.Ward;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepository extends MongoRepository<Ward, Long> {
    // Custom query methods can be defined here
}
