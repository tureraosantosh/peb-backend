package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "intake_ordering_practitioners")
public class OrderingPractitionerEntity extends SoftDeletableEntity {
    @Column private String orderingPhysicianFirstName;
    @Column private String orderingPhysicianLastName;
    @Column private String orderingPhysicianNumber;
    @Column private String orderingPhysicianFax;
    @Column private String orderingPhysicianExternalId;
    @Column private String orderingPhysicianAddress;
    @Column private String orderingPhysicianCity;
    @Column private String orderingPhysicianState;
    @Column private String orderingPhysicianNpi;
    @Column private String orderingPhysicianTin;
    @Column private String orderingPhysicianZipCode;

    public String getOrderingPhysicianFirstName() { return orderingPhysicianFirstName; }
    public void setOrderingPhysicianFirstName(String value) { this.orderingPhysicianFirstName = value; }
    public String getOrderingPhysicianLastName() { return orderingPhysicianLastName; }
    public void setOrderingPhysicianLastName(String value) { this.orderingPhysicianLastName = value; }
    public String getOrderingPhysicianNumber() { return orderingPhysicianNumber; }
    public void setOrderingPhysicianNumber(String value) { this.orderingPhysicianNumber = value; }
    public String getOrderingPhysicianFax() { return orderingPhysicianFax; }
    public void setOrderingPhysicianFax(String value) { this.orderingPhysicianFax = value; }
    public String getOrderingPhysicianExternalId() { return orderingPhysicianExternalId; }
    public void setOrderingPhysicianExternalId(String value) { this.orderingPhysicianExternalId = value; }
    public String getOrderingPhysicianAddress() { return orderingPhysicianAddress; }
    public void setOrderingPhysicianAddress(String value) { this.orderingPhysicianAddress = value; }
    public String getOrderingPhysicianCity() { return orderingPhysicianCity; }
    public void setOrderingPhysicianCity(String value) { this.orderingPhysicianCity = value; }
    public String getOrderingPhysicianState() { return orderingPhysicianState; }
    public void setOrderingPhysicianState(String value) { this.orderingPhysicianState = value; }
    public String getOrderingPhysicianNpi() { return orderingPhysicianNpi; }
    public void setOrderingPhysicianNpi(String value) { this.orderingPhysicianNpi = value; }
    public String getOrderingPhysicianTin() { return orderingPhysicianTin; }
    public void setOrderingPhysicianTin(String value) { this.orderingPhysicianTin = value; }
    public String getOrderingPhysicianZipCode() { return orderingPhysicianZipCode; }
    public void setOrderingPhysicianZipCode(String value) { this.orderingPhysicianZipCode = value; }
}

