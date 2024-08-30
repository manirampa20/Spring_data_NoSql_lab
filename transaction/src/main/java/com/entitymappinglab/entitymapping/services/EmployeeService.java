package com.entitymappinglab.entitymapping.services;

import com.entitymappinglab.entitymapping.modules.Employee;
import com.entitymappinglab.entitymapping.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Example of a method using declarative transaction management
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Example of a method with caching
    @Cacheable(value = "employees", key = "#id")
    public Employee findEmployeeById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Method to get all employees
    @Cacheable(value = "employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Cache eviction example
    @CacheEvict(value = "employees", allEntries = true)
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
