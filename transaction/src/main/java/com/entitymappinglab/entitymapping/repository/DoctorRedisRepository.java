package com.entitymappinglab.entitymapping.repository;

import com.entitymappinglab.entitymapping.modules.Doctor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRedisRepository extends CrudRepository<Doctor, String> {
    // Define custom queries if needed
}