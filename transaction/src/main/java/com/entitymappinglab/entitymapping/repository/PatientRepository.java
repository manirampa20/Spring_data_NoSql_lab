package com.entitymappinglab.entitymapping.repository;

import com.entitymappinglab.entitymapping.modules.Patient;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, Long> {
    // Custom query methods if needed
}
