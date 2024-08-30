package com.entitymappinglab.entitymapping.services;

import com.entitymappinglab.entitymapping.modules.Doctor;

import com.entitymappinglab.entitymapping.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctorById(String id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor updateDoctor(String id, Doctor doctorDetails) {
        Doctor doctor = getDoctorById(id);
        if (doctor != null) {
            doctor.setSpecialty(doctorDetails.getSpecialty());
            // Update other fields as necessary
            return doctorRepository.save(doctor);
        } else {
            return null;
        }
    }

    public boolean deleteDoctor(String id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
