package com.entitymappinglab.entitymapping.modules;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "employees")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String emNo; // MongoDB uses ObjectId for IDs, but keeping it as String is fine

    private String surname;
    private String firstName;
    private String address;
    private String telephone;

    // Getters and Setters
    public String getEmNo() {
        return emNo;
    }

    public void setEmNo(String emNo) {
        this.emNo = emNo;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
