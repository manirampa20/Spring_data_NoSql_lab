package com.entitymappinglab.entitymapping.repository;

import com.entitymappinglab.entitymapping.modules.Hospitalisation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalisationRepository extends MongoRepository<Hospitalisation, Long> {
    // Define custom queries if needed
}
