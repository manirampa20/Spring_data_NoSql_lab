package com.entitymappinglab.entitymapping.controllers;

import com.entitymappinglab.entitymapping.modules.Doctor;
import com.entitymappinglab.entitymapping.services.DoctorService;
import com.entitymappinglab.entitymapping.services.DoctorRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorRedisService doctorRedisService;

    // Save a new doctor
    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        // Save doctor to the database
        Doctor savedDoctor = doctorService.createDoctor(doctor);
        // Cache the doctor in Redis
        doctorRedisService.setDoctor("doctor:" + savedDoctor.getEmNo(), savedDoctor);
        return ResponseEntity.ok(savedDoctor);
    }

    // Get a doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable String id) {
        // Try to get the doctor from Redis cache
        Doctor doctor = doctorRedisService.getDoctor("doctor:" + id);
        if (doctor == null) {
            // If not in Redis, fetch from database
            doctor = doctorService.getDoctorById(id);
            if (doctor != null) {
                // Cache the result in Redis for future requests
                doctorRedisService.setDoctor("doctor:" + id, doctor);
            }
        }
        return doctor != null ? ResponseEntity.ok(doctor) : ResponseEntity.notFound().build();
    }

//     Get all doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {

        List<Doctor> doctors = doctorRedisService.getAllDoctors();

        if(doctors.isEmpty()) {
            doctors = doctorService.getAllDoctors();

            for (Doctor doctor : doctors) {
                doctorRedisService.setDoctor("doctor:" + doctor.getEmNo(), doctor);
            }
        }
        return ResponseEntity.ok(doctors);

        }





    // Fetch all doctors from the database
//        List<Doctor> doctors = doctorService.getAllDoctors();
//        return ResponseEntity.ok(doctors);


    // Update an existing doctor
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable String id, @RequestBody Doctor doctorDetails){
        Doctor updateDoctor = doctorService.updateDoctor(id, doctorDetails);
        doctorRedisService.updateDoctor("doctor:" +id, updateDoctor);
        return ResponseEntity.ok(updateDoctor);
    }



//    public ResponseEntity<Doctor> updateDoctor(@PathVariable String id, @RequestBody Doctor doctorDetails) {
//        // Update the doctor in the database
//        Doctor updatedDoctor = doctorService.updateDoctor(id, doctorDetails);
//        if (updatedDoctor != null) {
//            // Update the cache in Redis
//            doctorRedisService.setDoctor("doctor:" + id, updatedDoctor);
//
//            return ResponseEntity.ok(updatedDoctor);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    // Delete a doctor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable String id) {
        // Delete the doctor from the database
        boolean deleted = doctorService.deleteDoctor(id);
        if (deleted) {
            // Evict the doctor from the Redis cache
            doctorRedisService.deleteDoctor("doctor:" + id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
