package com.entitymappinglab.entitymapping.modules;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "doctors")
public class Doctor extends Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String specialty;

    // Getters and Setters
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
