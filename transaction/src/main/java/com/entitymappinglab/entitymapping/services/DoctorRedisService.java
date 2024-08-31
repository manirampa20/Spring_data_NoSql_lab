package com.entitymappinglab.entitymapping.services;



import com.entitymappinglab.entitymapping.modules.Doctor;
import com.entitymappinglab.entitymapping.repository.DoctorRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorRedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private DoctorRedisRepository doctorRedisRepository;

    // Set a doctor in Redis
    public void setDoctor(String key, Doctor doctor) {
        redisTemplate.opsForValue().set(key, doctor);
    }

    // Get a doctor from Redis
    public Doctor getDoctor(String key) {
        return (Doctor) redisTemplate.opsForValue().get(key);
    }

    // Save a doctor in Redis
    public void saveDoctor(Doctor doctor) {
        doctorRedisRepository.save(doctor);
    }

    // Find a doctor by ID in Redis
    public Doctor findDoctorById(String id) {
        return doctorRedisRepository.findById(id).orElse(null);
    }

    // Update a doctor in Redis
    public void updateDoctor(String key, Doctor doctor) {
        redisTemplate.opsForValue().set(key, doctor);
    }

    // Delete a doctor by ID in Redis
    public void deleteDoctor(String key) {
        redisTemplate.delete(key);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        List<Object> doctors = redisTemplate.opsForValue().multiGet(redisTemplate.keys("doctor:*"));
        return doctors.stream().map(d -> (Doctor) d).collect(Collectors.toList());
    }
}
