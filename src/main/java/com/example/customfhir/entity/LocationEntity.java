package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "intake_locations")
public class LocationEntity extends SoftDeletableEntity {
    @Column private String facility;
    @Column private String facilityNpi;
    @Column private String facilityTin;
    @Column private String facilityFax;
    @Column private String facilityAddress;
    @Column private String facilityCity;
    @Column private String facilityState;
    @Column private String zipCode;
    @Column private String orderingFacilityName;
    @Column private String orderingFacilityNpi;
    @Column private String orderingFacilityAddress;
    @Column private String orderingFacilityCity;
    @Column private String orderingFacilityState;
    @Column private String orderingFacilityZipCode;
    @Column private String orderingFacilityFax;
    @Column private String orderingFacilityPhone;
    public String getFacility() { return facility; } public void setFacility(String v) { facility = v; }
    public String getFacilityNpi() { return facilityNpi; } public void setFacilityNpi(String v) { facilityNpi = v; }
    public String getFacilityTin() { return facilityTin; } public void setFacilityTin(String v) { facilityTin = v; }
    public String getFacilityFax() { return facilityFax; } public void setFacilityFax(String v) { facilityFax = v; }
    public String getFacilityAddress() { return facilityAddress; } public void setFacilityAddress(String v) { facilityAddress = v; }
    public String getFacilityCity() { return facilityCity; } public void setFacilityCity(String v) { facilityCity = v; }
    public String getFacilityState() { return facilityState; } public void setFacilityState(String v) { facilityState = v; }
    public String getZipCode() { return zipCode; } public void setZipCode(String v) { zipCode = v; }
    public String getOrderingFacilityName() { return orderingFacilityName; } public void setOrderingFacilityName(String v) { orderingFacilityName = v; }
    public String getOrderingFacilityNpi() { return orderingFacilityNpi; } public void setOrderingFacilityNpi(String v) { orderingFacilityNpi = v; }
    public String getOrderingFacilityAddress() { return orderingFacilityAddress; } public void setOrderingFacilityAddress(String v) { orderingFacilityAddress = v; }
    public String getOrderingFacilityCity() { return orderingFacilityCity; } public void setOrderingFacilityCity(String v) { orderingFacilityCity = v; }
    public String getOrderingFacilityState() { return orderingFacilityState; } public void setOrderingFacilityState(String v) { orderingFacilityState = v; }
    public String getOrderingFacilityZipCode() { return orderingFacilityZipCode; } public void setOrderingFacilityZipCode(String v) { orderingFacilityZipCode = v; }
    public String getOrderingFacilityFax() { return orderingFacilityFax; } public void setOrderingFacilityFax(String v) { orderingFacilityFax = v; }
    public String getOrderingFacilityPhone() { return orderingFacilityPhone; } public void setOrderingFacilityPhone(String v) { orderingFacilityPhone = v; }
}

