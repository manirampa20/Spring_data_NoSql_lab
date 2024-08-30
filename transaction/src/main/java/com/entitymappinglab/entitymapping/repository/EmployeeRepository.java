package com.entitymappinglab.entitymapping.repository;

import com.entitymappinglab.entitymapping.modules.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    // Custom query methods can be defined here if needed
}
