package com.entitymappinglab.entitymapping.repository;

import com.entitymappinglab.entitymapping.modules.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
    // Define custom queries if needed
}
