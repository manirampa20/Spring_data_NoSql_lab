package com.entitymappinglab.entitymapping.services;


import com.entitymappinglab.entitymapping.modules.Doctor;
import com.entitymappinglab.entitymapping.repository.DoctorRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorRedisService {

    private final DoctorRedisRepository doctorRedisRepository;

    @Autowired
    public DoctorRedisService(DoctorRedisRepository doctorRedisRepository) {
        this.doctorRedisRepository = doctorRedisRepository;
    }

    // Save a doctor to Redis (setDoctor)
    public void setDoctor(String key, Doctor doctor) {
        doctorRedisRepository.save(doctor);
    }

    // Get a doctor from Redis by key (getDoctor)
    public Doctor getDoctor(String key) {
        return doctorRedisRepository.findById(key).orElse(null);
    }

    // Save a doctor
    public Doctor createDoctor(Doctor doctor) {
        return doctorRedisRepository.save(doctor);
    }

    // Get a doctor by ID
    public Doctor getDoctorById(String id) {
        return doctorRedisRepository.findById(id).orElse(null);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        // Return all doctors as a list
        return (List<Doctor>) doctorRedisRepository.findAll();
    }

    // Update a doctor
    public Doctor updateDoctor(String id, Doctor doctor) {
        if (doctorRedisRepository.existsById(id)) {
            doctor.setEmNo(id);
            return doctorRedisRepository.save(doctor);
        } else {
            return null;
        }
    }

    // Delete a doctor by ID
    public void deleteDoctor(String id) {
        doctorRedisRepository.deleteById(id);
    }
}
