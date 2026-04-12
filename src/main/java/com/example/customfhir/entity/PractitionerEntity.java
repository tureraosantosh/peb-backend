package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "intake_practitioners")
public class PractitionerEntity extends SoftDeletableEntity {

    @Column private String physicianFirstName;
    @Column private String physicianLastName;
    @Column private String physicianFax;
    @Column private String physicianAddress;
    @Column private String physicianCity;
    @Column private String physicianState;
    @Column private String physicianNpi;
    @Column private String zipCode;
    @Column private String physicianNumber;
    @Column private String physicianExternalId;
    @Column private String physicianTin;

    public String getPhysicianFirstName() { return physicianFirstName; }
    public void setPhysicianFirstName(String physicianFirstName) { this.physicianFirstName = physicianFirstName; }
    public String getPhysicianLastName() { return physicianLastName; }
    public void setPhysicianLastName(String physicianLastName) { this.physicianLastName = physicianLastName; }
    public String getPhysicianFax() { return physicianFax; }
    public void setPhysicianFax(String physicianFax) { this.physicianFax = physicianFax; }
    public String getPhysicianAddress() { return physicianAddress; }
    public void setPhysicianAddress(String physicianAddress) { this.physicianAddress = physicianAddress; }
    public String getPhysicianCity() { return physicianCity; }
    public void setPhysicianCity(String physicianCity) { this.physicianCity = physicianCity; }
    public String getPhysicianState() { return physicianState; }
    public void setPhysicianState(String physicianState) { this.physicianState = physicianState; }
    public String getPhysicianNpi() { return physicianNpi; }
    public void setPhysicianNpi(String physicianNpi) { this.physicianNpi = physicianNpi; }
    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public String getPhysicianNumber() { return physicianNumber; }
    public void setPhysicianNumber(String physicianNumber) { this.physicianNumber = physicianNumber; }
    public String getPhysicianExternalId() { return physicianExternalId; }
    public void setPhysicianExternalId(String physicianExternalId) { this.physicianExternalId = physicianExternalId; }
    public String getPhysicianTin() { return physicianTin; }
    public void setPhysicianTin(String physicianTin) { this.physicianTin = physicianTin; }
}

