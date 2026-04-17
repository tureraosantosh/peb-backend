package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "intake_appointments")
public class AppointmentEntity extends SoftDeletableEntity {
    @Column private OffsetDateTime dateOfServiceStart;
    @Column private String transactionId;
    @Column private OffsetDateTime dateOfServiceEnd;
    @Column private String admissionType;
    @Column private String patientClass;
    @Column private String expOrderId;
    @Column private String appointmentType;
    @Column private String priority;
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
    public OffsetDateTime getDateOfServiceStart() { return dateOfServiceStart; } public void setDateOfServiceStart(OffsetDateTime v) { dateOfServiceStart = v; }
    public String getTransactionId() { return transactionId; } public void setTransactionId(String v) { transactionId = v; }
    public OffsetDateTime getDateOfServiceEnd() { return dateOfServiceEnd; } public void setDateOfServiceEnd(OffsetDateTime v) { dateOfServiceEnd = v; }
    public String getAdmissionType() { return admissionType; } public void setAdmissionType(String v) { admissionType = v; }
    public String getPatientClass() { return patientClass; } public void setPatientClass(String v) { patientClass = v; }
    public String getExpOrderId() { return expOrderId; } public void setExpOrderId(String v) { expOrderId = v; }
    public String getAppointmentType() { return appointmentType; } public void setAppointmentType(String v) { appointmentType = v; }
    public String getPriority() { return priority; } public void setPriority(String v) { priority = v; }
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

