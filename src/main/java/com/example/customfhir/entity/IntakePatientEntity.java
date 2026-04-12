package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "intake_patients")
public class IntakePatientEntity extends SoftDeletableEntity {
    @Column private String patientFirstName;
    @Column private String patientLastName;
    @Column private String patientId;
    @Column private LocalDate dateOfBirth;
    @Column private String gender;
    @Column private String patientMiddleName;
    @Column private String phoneNumber;
    @Column private String streetAddress;
    @Column private String city;
    @Column private String state;
    @Column private String zipCode;
    @Column(length = 10000) private String notes;
    public String getPatientFirstName() { return patientFirstName; } public void setPatientFirstName(String v) { patientFirstName = v; }
    public String getPatientLastName() { return patientLastName; } public void setPatientLastName(String v) { patientLastName = v; }
    public String getPatientId() { return patientId; } public void setPatientId(String v) { patientId = v; }
    public LocalDate getDateOfBirth() { return dateOfBirth; } public void setDateOfBirth(LocalDate v) { dateOfBirth = v; }
    public String getGender() { return gender; } public void setGender(String v) { gender = v; }
    public String getPatientMiddleName() { return patientMiddleName; } public void setPatientMiddleName(String v) { patientMiddleName = v; }
    public String getPhoneNumber() { return phoneNumber; } public void setPhoneNumber(String v) { phoneNumber = v; }
    public String getStreetAddress() { return streetAddress; } public void setStreetAddress(String v) { streetAddress = v; }
    public String getCity() { return city; } public void setCity(String v) { city = v; }
    public String getState() { return state; } public void setState(String v) { state = v; }
    public String getZipCode() { return zipCode; } public void setZipCode(String v) { zipCode = v; }
    public String getNotes() { return notes; } public void setNotes(String v) { notes = v; }
}

